package enzocesarano.GestionePrenotazioni.service;

import enzocesarano.GestionePrenotazioni.entities.Postazione;
import enzocesarano.GestionePrenotazioni.entities.Prenotazione;
import enzocesarano.GestionePrenotazioni.entities.TipoPostazione;
import enzocesarano.GestionePrenotazioni.entities.Utente;
import enzocesarano.GestionePrenotazioni.repository.PostazioneRepository;
import enzocesarano.GestionePrenotazioni.repository.PrenotazioneRepository;
import enzocesarano.GestionePrenotazioni.repository.UtenteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PrenotazioneService {

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    @Autowired
    private PostazioneRepository postazioneRepository;

    @Autowired
    private UtenteRepository utenteRepository;

    public List<Postazione> cercaPostazioni(TipoPostazione tipo, String citta) {
        return postazioneRepository.findByTipoAndEdificioCitta(tipo, citta);
    }

    public void creaPrenotazione(Utente utente1, Postazione posizione1, LocalDate data) {
        try {
            Utente utente = utenteRepository.findById(utente1.getId_utente())                                       // verifichiamo utente e postazione
                    .orElseThrow(() -> new EntityNotFoundException("Utente non trovato"));
            Postazione postazione = postazioneRepository.findById(posizione1.getIdPostazione())
                    .orElseThrow(() -> new EntityNotFoundException("Postazione non trovata"));

            boolean prenotazioneEsistente = prenotazioneRepository.existsByUtenteAndDataPrenotazione(utente, data); // verifichiamo se esiste una prenotazione di quell'utente per la data specifica
            if (prenotazioneEsistente) {
                throw new IllegalArgumentException("L'utente ha già una prenotazione per questa data");
            }

            long numeroPrenotazioni = prenotazioneRepository.countByDataPrenotazioneAndPostazione(data, postazione); // verifichiamo che il numero di prenotazioni per una postazione in una data specifica sia minore del numero massimo di occupanti
            if (numeroPrenotazioni >= postazione.getMaxOccupanti()) {
                throw new IllegalArgumentException("Postazione piena, non è possibile effettuare la prenotazione");
            }
            if (prenotazioneRepository.findByDataPrenotazioneAndPostazione(data, postazione).isPresent()) {
                throw new IllegalArgumentException("Postazione già prenotata per questa data");
            }
            Prenotazione prenotazione = new Prenotazione(data, utente, postazione);
            prenotazioneRepository.save(prenotazione);
            System.out.println("La prenotazione " + prenotazione.getIdPrenotazione() + " è stata creata con successo!");

        } catch (EntityNotFoundException | IllegalArgumentException e) {
            System.out.println("Errore: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Si è verificato un errore imprevisto: " + e.getMessage());
        }
    }
}
