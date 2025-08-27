package be.ehb.mangaapi.Controller;

import be.ehb.mangaapi.Model.Boek;
import be.ehb.mangaapi.Model.DAO.BoekDAO;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/boek")
public class BoekController {

    private final BoekDAO boekDAO;

    public BoekController(BoekDAO boekDAO) {
        this.boekDAO = boekDAO;
    }

    // Boek verwijderen op id
    @DeleteMapping
    public void verwijderBoek(@RequestParam Long id) {
        boekDAO.deleteById(id);
    }

    @GetMapping("/alle")
    public List<Boek> getAlleBoeken() {
        return boekDAO.findAll();
    }

    // Boeken op genre zoeken
    @GetMapping("/{genre}")
    public List<Boek> getBoekenOpGenre(@PathVariable String genre) {
        return boekDAO.findByGenre(genre);
    }

    @PostMapping("/nieuw")
    public Boek registreerBoek(
            @RequestParam String naam,
            @RequestParam String omschrijving,
            @RequestParam String genre,
            @RequestParam String prijs, // komt binnen als string
            @RequestParam(required = false) String reeks
    ) {
        Boek boek = new Boek();
        boek.setNaam(naam);
        boek.setOmschrijving(omschrijving);
        boek.setGenre(genre);
        boek.setPrijs(new BigDecimal(prijs)); // omzetten naar BigDecimal
        boek.setReeks(reeks);
        return boekDAO.save(boek);
    }
}
