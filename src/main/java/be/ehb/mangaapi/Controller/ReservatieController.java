package be.ehb.mangaapi.Controller;

import be.ehb.mangaapi.Model.DAO.BoekDAO;
import be.ehb.mangaapi.Model.DAO.KlantDAO;
import be.ehb.mangaapi.Model.DAO.ReservatieDAO;
import be.ehb.mangaapi.Model.Reservatie;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/reservatie")
public class ReservatieController {

    private ReservatieDAO reservatieDAO;
    private KlantDAO klantDAO;
    private BoekDAO boekDAO;

    public ReservatieController(ReservatieDAO reservatieDAO) {
        this.reservatieDAO = reservatieDAO;
    }

    // Nieuwe reservatie aanmaken
    @PostMapping
    public Reservatie maakReservatie(@RequestBody Reservatie reservatie) {
        return reservatieDAO.save(reservatie);
    }

    @PostMapping("/nieuw")
    public Reservatie maakReservatie(
            @RequestParam Long klantId,
            @RequestParam Long boekId,
            @RequestParam String leverDatum // bv. "2025-09-30"
    ) {
        Reservatie reservatie = new Reservatie();

        // Klant en Boek ophalen via DAO
        klantDAO.findById(klantId).ifPresent(reservatie::setKlant);
        boekDAO.findById(boekId).ifPresent(reservatie::setBoek);

        // Leverdatum omzetten naar LocalDate
        reservatie.setLeverDatum(LocalDate.parse(leverDatum));

        return reservatieDAO.save(reservatie);
    }
}
