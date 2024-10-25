# Sistema di Prenotazione Postazioni

Questo progetto implementa un sistema di prenotazione per postazioni di lavoro, che permette agli utenti di cercare e prenotare postazioni disponibili in base a vari criteri, come il tipo di postazione e la città.

## Descrizione del Progetto

Il sistema consente agli utenti di:

1. Inserire il proprio ID per identificarsi.
2. Specificare il tipo di postazione desiderata (ad esempio, PRIVATO, OPENSPACE, SALA_RIUNIONI).
3. Inserire la città in cui desiderano prenotare la postazione.
4. Visualizzare le postazioni disponibili e selezionare quella desiderata.
5. Prenotare la postazione per una data specificata.

## Requisiti

- Java 8 o superiore
- Librerie di terze parti (se necessarie) per la gestione delle prenotazioni e delle entità.

## Struttura del Progetto

### Classi Principali

- `Utente`: rappresenta l'utente che prenota la postazione.
- `Postazione`: rappresenta le postazioni disponibili.
- `TipoPostazione`: enum che definisce i tipi di postazioni (PRIVATO, OPENSPACE, SALA_RIUNIONI).
- `PrenotazioneService`: gestisce la logica di prenotazione delle postazioni.
- `UtenteRepository`: interfaccia per la gestione degli utenti.

## Come Utilizzare

1. **Esegui l'applicazione**: Avvia il programma. 
2. **Inserisci l'ID dell'utente**: Il programma chiederà di inserire l'ID dell'utente. Questo ID deve essere valido e corrispondere a un utente esistente nel sistema.
3. **Seleziona il tipo di postazione**: Scegli tra i tipi di postazioni disponibili.
4. **Inserisci la città**: Specifica la città in cui desideri trovare una postazione.
5. **Visualizza le postazioni disponibili**: Se ci sono postazioni disponibili, verranno elencate con le relative informazioni.
6. **Seleziona la postazione**: Scegli una postazione dall'elenco o annulla l'operazione.
7. **Prenota la postazione**: Inserisci la data di prenotazione seguendo il formato AAAA-MM-GG.

## Gestione degli Errori

Il sistema gestisce vari tipi di eccezioni, tra cui:

- **EntityNotFoundException**: Se l'utente non viene trovato.
- **IllegalArgumentException**: Se il tipo di postazione non è valido.
- **DateTimeParseException**: Se il formato della data inserita è errato.
- **Eccezioni generiche**: Gestisce eventuali errori imprevisti.

## Contribuire

Se desideri contribuire al progetto, sei il benvenuto! Puoi aprire un issue o inviare una pull request con miglioramenti e correzioni.

## Licenza

Questo progetto è sotto la licenza [Nome Licenza]. Consulta il file `LICENSE` per ulteriori dettagli.
