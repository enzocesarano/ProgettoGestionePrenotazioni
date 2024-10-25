package enzocesarano.GestionePrenotazioni.entities;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@ToString
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id_utente;
    private String username;
    private String nome_completo;
    private String email;

    @OneToMany(mappedBy = "utente")
    private List<Prenotazione> prenotazioni;

    public Utente(String username, String nome_completo, String email) {
        this.username = username;
        this.nome_completo = nome_completo;
        this.email = email;
    }

    public UUID getId_utente() {
        return id_utente;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNome_completo() {
        return nome_completo;
    }

    public void setNome_completo(String nome_completo) {
        this.nome_completo = nome_completo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Prenotazione> getPrenotazioni() {
        return prenotazioni;
    }

    public void setPrenotazioni(List<Prenotazione> prenotazioni) {
        this.prenotazioni = prenotazioni;
    }
}