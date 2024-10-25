package enzocesarano.GestionePrenotazioni.runners;

import enzocesarano.GestionePrenotazioni.entities.Postazione;
import enzocesarano.GestionePrenotazioni.entities.TipoPostazione;
import enzocesarano.GestionePrenotazioni.entities.Utente;
import enzocesarano.GestionePrenotazioni.repository.EdificioRepository;
import enzocesarano.GestionePrenotazioni.repository.PostazioneRepository;
import enzocesarano.GestionePrenotazioni.repository.UtenteRepository;
import enzocesarano.GestionePrenotazioni.service.EdificioService;
import enzocesarano.GestionePrenotazioni.service.PostazioneService;
import enzocesarano.GestionePrenotazioni.service.PrenotazioneService;
import enzocesarano.GestionePrenotazioni.service.UtenteService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.UUID;

@Component
public class PrenotazioneRunner implements CommandLineRunner {

    @Autowired
    private PrenotazioneService prenotazioneService;

    @Autowired
    private PostazioneService postazioneService;

    @Autowired
    private UtenteRepository utenteRepository;

    @Autowired
    private PostazioneRepository postazioneRepository;

    @Autowired
    private EdificioRepository edificioRepository;

    @Autowired
    private UtenteService utenteService;

    @Autowired
    private EdificioService edificioService;

    @Override
    public void run(String... args) throws Exception {

// **********************************************************************************************************************************************************************
//
//        NON AVEVO FATTO I CONTROLLI SULLA CREAZIONE DELL'UTENTE E DEGLI EDIFICI.
//
//        utenteService.creaUtente("jorah.mormont", "Jorah Mormont", "jorah@gmail.com");
//        edificioService.creaEdificio("Nido dell'Aquila", "Via della Rocca 1", "Vallate");
//
//        QUESTI DUE ESEMPI CONTROLLANO ALLA CREAZIONE SE ESISTE GIA' UNA MAIL E/O UN USERNAME (CASO UTENTE) E SE ESISTE GIA' UNA VIA (CASO EDIFICIO)
//
// **********************************************************************************************************************************************************************


        // Creo UTENTE, EDIFICIO E POSTAZIONE ********************************************

//        Utente vincenzo = utenteRepository.save(new Utente("enzo.cesarano", "Vincenzo Cesarano", "vinc.cesarano@gmail.com");
//        Utente daenerys = utenteRepository.save(new Utente("daenerys.targaryen", "Daenerys Targaryen", "daenerys@gmail.com"));
//        Utente jonSnow = utenteRepository.save(new Utente("jon.snow", "Jon Snow", "jon.snow@gmail.com"));
//        Utente tyrion = utenteRepository.save(new Utente("tyrion.lannister", "Tyrion Lannister", "tyrion@gmail.com"));
//        Utente arya = utenteRepository.save(new Utente("arya.stark", "Arya Stark", "arya@gmail.com"));
//        Utente cersei = utenteRepository.save(new Utente("cersei.lannister", "Cersei Lannister", "cersei@gmail.com"));
//        Utente ned = utenteRepository.save(new Utente("edard.stark", "Eddard Stark", "ned.stark@gmail.com"));
//        Utente sansa = utenteRepository.save(new Utente("sansa.stark", "Sansa Stark", "sansa@gmail.com"));
//        Utente bran = utenteRepository.save(new Utente("bran.stark", "Bran Stark", "bran@gmail.com"));
//        Utente petyr = utenteRepository.save(new Utente("petyr.baelish", "Petyr Baelish", "petyr@gmail.com"));
//        Utente jaime = utenteRepository.save(new Utente("jaime.lannister", "Jaime Lannister", "jaime@gmail.com"));
//        Utente khaleesi = utenteRepository.save(new Utente("khaleesi", "Khaleesi", "khaleesi@gmail.com"));
//        Utente melisandre = utenteRepository.save(new Utente("melisandre", "Melisandre", "melisandre@gmail.com"));
//        Utente brienne = utenteRepository.save(new Utente("brienne.tarth", "Brienne of Tarth", "brienne@gmail.com"));
//        Utente sandor = utenteRepository.save(new Utente("sandor.clegane", "Sandor Clegane", "sandor@gmail.com"));
//        Utente jorah = utenteRepository.save(new Utente("jorah.mormont", "Jorah Mormont", "jorah@gmail.com"));
//
//        Edificio edificioCentrale = edificioRepository.save(new Edificio("Edificio Centrale", "Via Roma 1", "Milano"));
//        Postazione salaRiunioni = postazioneRepository.save(new Postazione("Sala riunioni", TipoPostazione.SALA_RIUNIONI, 10, edificioCentrale));
//
//        Edificio castelloNidoDellAquila = edificioRepository.save(new Edificio("Nido dell'Aquila", "Via della Rocca 1", "Vallate"));
//        Edificio grandeInverno = edificioRepository.save(new Edificio("Grande Inverno", "Piazza degli Stark 2", "Nord"));
//        Edificio capitale = edificioRepository.save(new Edificio("Capitale", "Corso dei Lannister 3", "King's Landing"));
//        Edificio approdoDelRe = edificioRepository.save(new Edificio("Approdo del Re", "Via dei Targaryen 4", "King's Landing"));
//        Edificio grandeTempio = edificioRepository.save(new Edificio("Grande Tempio", "Largo dei Sette 5", "King's Landing"));
//        Edificio casaBaratheon = edificioRepository.save(new Edificio("Forte del Castigo", "Via dei Baratheon 6", "Stormlands"));
//        Edificio casaTargaryen = edificioRepository.save(new Edificio("Dragonstone", "Piazza dei Draghi 7", "Dragonstone"));
//
//        String[] nomiEdifici = {
//                "Nido dell'Aquila",
//                "Grande Inverno",
//                "Capitale",
//                "Approdo del Re",
//                "Grande Tempio",
//                "Forte del Castigo",
//                "Dragonstone"
//        };
//
//        for (String nome : nomiEdifici) {
//            try {
//                Edificio edificio = edificioRepository.findByNome(nome).orElseThrow(() -> new EntityNotFoundException("Edificio non trovato: " + nome));
//                postazioneService.creaSalaPrivata(edificio);
//                postazioneService.creaOpenSace(edificio);
//                postazioneService.creaSalaRiunioni(edificio);
//            } catch (EntityNotFoundException e) {
//                System.out.println(e.getMessage());
//            } catch (Exception e) {
//                System.out.println("Si è verificato un errore: " + e.getMessage());
//            }


        // Creo una prima PRENOTAZIONE **********************************************

//        Optional<Utente> vincenzoOp = utenteRepository.findById(UUID.fromString("c33f5e07-5afa-4d4f-b595-046c41629e54"));
//        Optional<Postazione> salaRiunioniOp = postazioneRepository.findById(UUID.fromString("e49d3ea2-f208-4c26-86b2-5db36cdbcfc0"));
//
//        LocalDate dataPrenotazione = LocalDate.now();
//
//        try {
//            Utente vincenzo = vincenzoOp.orElseThrow(() -> new EntityNotFoundException("Utente non trovato"));
//            Postazione salaRiunioni = salaRiunioniOp.orElseThrow(() -> new EntityNotFoundException("Postazione non trovata"));
//
//            prenotazioneService.creaPrenotazione(vincenzo, salaRiunioni, dataPrenotazione);
//            System.out.println("Prenotazione creata con successo per " + vincenzo.getNome_completo() + " nella data " + dataPrenotazione);
//        } catch (IllegalArgumentException e) {
//            System.out.println("Errore nella creazione della prenotazione: " + e.getMessage());
//        } catch (EntityNotFoundException e) {
//            System.out.println("Errore: " + e.getMessage());
//        }


        // Controllo con una nuova prenotazione se ne esiste una per quell'utente e quella data prenotazioni **********************************************

//        Optional<Utente> vincenzoOp = utenteRepository.findById(UUID.fromString("c33f5e07-5afa-4d4f-b595-046c41629e54"));
//        Optional<Postazione> salaRiunioniOp = postazioneRepository.findById(UUID.fromString("e49d3ea2-f208-4c26-86b2-5db36cdbcfc0"));
//
//        LocalDate dataPrenotazione = LocalDate.now();
//
//        try {
//            Utente vincenzo = vincenzoOp.orElseThrow(() -> new EntityNotFoundException("Utente non trovato"));
//            Postazione salaRiunioni = salaRiunioniOp.orElseThrow(() -> new EntityNotFoundException("Postazione non trovata"));
//
//            prenotazioneService.creaPrenotazione(vincenzo, salaRiunioni, dataPrenotazione);
//            System.out.println("Prenotazione creata con successo per " + vincenzo.getNome_completo() + " nella data " + dataPrenotazione);
//        } catch (IllegalArgumentException e) {
//            System.out.println("Errore nella creazione della prenotazione: " + e.getMessage());
//        } catch (EntityNotFoundException e) {
//            System.out.println("Errore: " + e.getMessage());
//        } // Errore nella creazione della prenotazione: Postazione già prenotata per questa data


        //  CREAZIONE DI UNA PRENOTAZIONE TRAMITE SCANNER DOPO LA SISTEMAZIONE DEI SERVICE

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Inserisci l'ID dell'utente: ");
            String id_utente = scanner.nextLine();
            Optional<Utente> utenteOp = utenteRepository.findById(UUID.fromString(id_utente));
            Utente utente = utenteOp.orElseThrow(() -> new EntityNotFoundException("Utente non trovato"));

            System.out.print("Inserisci il tipo di postazione (ad esempio, PRIVATO, OPENSPACE, SALA_RIUNIONI): ");
            String tipoInput = scanner.nextLine();
            TipoPostazione tipoPostazione = TipoPostazione.valueOf(tipoInput.toUpperCase());

            System.out.print("Inserisci la città della postazione: ");
            String citta = scanner.nextLine();

            List<Postazione> postazioniDisponibili = prenotazioneService.cercaPostazioni(tipoPostazione, citta);
            if (postazioniDisponibili.isEmpty()) {
                System.out.println("Nessuna postazione disponibile.");
            } else {
                System.out.println("Postazioni disponibili:");
                for (int i = 0; i < postazioniDisponibili.size(); i++) {
                    Postazione postazione = postazioniDisponibili.get(i);
                    System.out.println((i + 1) + ". ID: " + postazione.getIdPostazione() + ", Descrizione: "
                            + postazione.getDescrizione() + ", Edificio: " + postazione.getEdificio().getNome());
                }
                System.out.println("0. Esci");

                System.out.print("Seleziona il numero della postazione desiderata o 0 per uscire: ");
                int scelta = scanner.nextInt();

                if (scelta == 0) {
                    System.out.println("Operazione annullata.");
                } else if (scelta > 0 && scelta <= postazioniDisponibili.size()) {
                    Postazione postazioneSelezionata = postazioniDisponibili.get(scelta - 1);
                    scanner.nextLine();
                    System.out.print("Inserisci la data di prenotazione (formato AAAA-MM-GG): ");
                    String dataInput = scanner.nextLine();
                    LocalDate dataPrenotazione = LocalDate.parse(dataInput);
                    prenotazioneService.creaPrenotazione(utente, postazioneSelezionata, dataPrenotazione);
                } else {
                    System.out.println("Scelta non valida.");
                }
            }

        } catch (EntityNotFoundException | IllegalArgumentException e) {
            System.out.println("Errore: " + e.getMessage());
        } catch (DateTimeParseException e) {
            System.out.println("Errore: formato data non valido");
        } catch (Exception e) {
            System.out.println("Si è verificato un errore imprevisto: " + e.getMessage());
        } finally {
            scanner.close();
        }


    }
}
