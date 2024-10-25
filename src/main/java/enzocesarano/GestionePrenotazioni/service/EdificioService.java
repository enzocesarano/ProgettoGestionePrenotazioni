package enzocesarano.GestionePrenotazioni.service;

import enzocesarano.GestionePrenotazioni.entities.Edificio;
import enzocesarano.GestionePrenotazioni.repository.EdificioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EdificioService {

    @Autowired
    private EdificioRepository edificioRepository;

    public boolean existsByIndirizzo(String indirizzo) {
        Optional<Edificio> edificio = edificioRepository.findByIndirizzo(indirizzo);
        return edificio.isPresent();
    }

    public void creaEdificio(String nome, String indirizzo, String citta) {
        try {
            if (existsByIndirizzo(indirizzo)) {
                System.out.println("Edificio già esistente con l'indirizzo specificato.");
                return;
            }
            Edificio nuovoEdificio = new Edificio(nome, indirizzo, citta);
            edificioRepository.save(nuovoEdificio);
            System.out.println("Edificio creato con successo!");
        } catch (Exception e) {
            System.out.println("Errore durante la creazione dell'edificio: " + e.getMessage());
        }
    }
}
