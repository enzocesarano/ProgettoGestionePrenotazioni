package enzocesarano.GestionePrenotazioni.repository;

import enzocesarano.GestionePrenotazioni.entities.Postazione;
import enzocesarano.GestionePrenotazioni.entities.Prenotazione;
import enzocesarano.GestionePrenotazioni.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, UUID> {
    Optional<Prenotazione> findByDataPrenotazioneAndPostazione(LocalDate data, Postazione postazione);

    long countByDataPrenotazioneAndPostazione(LocalDate data, Postazione postazione);

    boolean existsByUtenteAndDataPrenotazione(Utente utente, LocalDate data);
}
