package enzocesarano.GestionePrenotazioni.entities;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.UUID;

@Entity
@NoArgsConstructor
@ToString
public class Postazione {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id_postazione;
    private String descrizione;
    @Enumerated(EnumType.STRING)
    private TipoPostazione tipo;
    private int maxOccupanti;
    @ManyToOne
    @JoinColumn(name = "id_edificio")
    private Edificio edificio;

    public Postazione(String descrizione, TipoPostazione tipo, int maxOccupanti, Edificio edificio) {
        this.descrizione = descrizione;
        this.tipo = tipo;
        this.maxOccupanti = maxOccupanti;
        this.edificio = edificio;
    }

    public UUID getIdPostazione() {
        return id_postazione;
    }

    public TipoPostazione getTipo() {
        return tipo;
    }

    public int getMaxOccupanti() {
        return maxOccupanti;
    }

    public Edificio getEdificio() {
        return edificio;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
}