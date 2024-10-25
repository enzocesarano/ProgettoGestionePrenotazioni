package enzocesarano.GestionePrenotazioni.service;

import enzocesarano.GestionePrenotazioni.entities.Edificio;
import enzocesarano.GestionePrenotazioni.entities.Postazione;
import enzocesarano.GestionePrenotazioni.entities.TipoPostazione;
import enzocesarano.GestionePrenotazioni.repository.PostazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class PostazioneService {

    private static final Random random = new Random();

    @Autowired
    private static PostazioneRepository postazioneRepository;

    @Autowired
    public PostazioneService(PostazioneRepository postazioneRepository) {
        PostazioneService.postazioneRepository = postazioneRepository;
    }

    public void creaSalaRiunioni(Edificio edificio) {
        int maxOccupanti = random.nextInt(16) + 5;

        Postazione salaRiunioni = new Postazione("Sala Riunioni", TipoPostazione.SALA_RIUNIONI, maxOccupanti, edificio);

        postazioneRepository.save(salaRiunioni);
    }

    public void creaOpenSace(Edificio edificio) {
        int maxOccupanti = random.nextInt(21) + 5;

        Postazione openSpace = new Postazione("Open Space", TipoPostazione.OPENSPACE, maxOccupanti, edificio);

        postazioneRepository.save(openSpace);
    }

    public void creaSalaPrivata(Edificio edificio) {
        int maxOccupanti = random.nextInt(11) + 5;

        Postazione salaRiunioni = new Postazione("Postazione Privata", TipoPostazione.PRIVATO, maxOccupanti, edificio);

        postazioneRepository.save(salaRiunioni);
    }
}