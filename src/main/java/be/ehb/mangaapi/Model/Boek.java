package be.ehb.mangaapi.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;


@Entity
public class Boek {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Naam is verplicht")
    private String naam;

    @NotBlank(message = "Omschrijving is verplicht")
    private String omschrijving;

    @NotBlank(message = "Genre is verplicht")
    private String genre;

    @DecimalMin(value = "1.5", message = "Prijs moet minstens 1.5 euro zijn")
    @NotNull(message = "Prijs is verplicht")
    private BigDecimal prijs;

    private String reeks; // optioneel

    // --- Constructors ---
    public Boek() {}

    public Boek(Long id, String naam, String omschrijving, String genre, BigDecimal prijs, String reeks) {
        this.id = id;
        this.naam = naam;
        this.omschrijving = omschrijving;
        this.genre = genre;
        this.prijs = prijs;
        this.reeks = reeks;
    }

    // --- Getters & Setters ---

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public BigDecimal getPrijs() {
        return prijs;
    }

    public void setPrijs(BigDecimal prijs) {
        this.prijs = prijs;
    }

    public String getReeks() {
        return reeks;
    }

    public void setReeks(String reeks) {
        this.reeks = reeks;
    }
}
