package enzocesarano.GestionePrenotazioni.repository;

import enzocesarano.GestionePrenotazioni.entities.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EdificioRepository extends JpaRepository<Edificio, Long> {
    Optional<Edificio> findByIndirizzo(String indirizzo);
}