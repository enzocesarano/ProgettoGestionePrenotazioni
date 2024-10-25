package enzocesarano.GestionePrenotazioni.service;

import enzocesarano.GestionePrenotazioni.entities.Utente;
import enzocesarano.GestionePrenotazioni.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UtenteService {

    @Autowired
    private UtenteRepository utenteRepository;

    public boolean existsByUsername(String username) {
        Optional<Utente> utente = utenteRepository.findByUsername(username);
        return utente.isPresent();
    }

    public boolean existsByEmail(String email) {
        Optional<Utente> utente = utenteRepository.findByEmail(email);
        return utente.isPresent();
    }

    public void creaUtente(String username, String nomeCompleto, String email) {
        try {
            if (existsByUsername(username) || existsByEmail(email)) {
                System.out.println("Username o email già esistenti");
                return;
            }
            Utente nuovoUtente = new Utente(username, nomeCompleto, email);
            utenteRepository.save(nuovoUtente);
            System.out.println("Utente creato con successo!");
        } catch (Exception e) {
            System.out.println("Errore durante la creazione dell'utente: " + e.getMessage());
        }
    }
}

