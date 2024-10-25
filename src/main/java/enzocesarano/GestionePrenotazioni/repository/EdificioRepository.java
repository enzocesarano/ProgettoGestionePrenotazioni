package enzocesarano.GestionePrenotazioni.repository;

import enzocesarano.GestionePrenotazioni.entities.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface EdificioRepository extends JpaRepository<Edificio, UUID> {
    Optional<Edificio> findByNome(String nome);
}