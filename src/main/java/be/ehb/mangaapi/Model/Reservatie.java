package be.ehb.mangaapi.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
public class Reservatie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @NotNull(message = "Klant is verplicht")
    private Klant klant;

    @ManyToOne
    @NotNull(message = "Boek is verplicht")
    private Boek boek;

    @Future(message = "Leverdatum moet in de toekomst liggen")
    @NotNull(message = "Leverdatum is verplicht")
    private LocalDate leverDatum;

    // --- Constructors ---
    public Reservatie() {}

    public Reservatie(Long id, Klant klant, Boek boek, LocalDate leverDatum) {
        this.id = id;
        this.klant = klant;
        this.boek = boek;
        this.leverDatum = leverDatum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Klant getKlant() {
        return klant;
    }

    public void setKlant(Klant klant) {
        this.klant = klant;
    }

    public Boek getBoek() {
        return boek;
    }

    public void setBoek(Boek boek) {
        this.boek = boek;
    }

    public LocalDate getLeverDatum() {
        return leverDatum;
    }

    public void setLeverDatum(LocalDate leverDatum) {
        this.leverDatum = leverDatum;
    }
}
