package be.ehb.mangaapi.Controller;


import be.ehb.mangaapi.Model.DAO.KlantDAO;
import be.ehb.mangaapi.Model.Klant;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/klant")
public class KlantController {

    private final KlantDAO klantDAO;

    public KlantController(KlantDAO klantDAO) {
        this.klantDAO = klantDAO;
    }

    // Alle klanten ophalen
    @GetMapping("/alle")
    public List<Klant> getAlleKlanten() {
        return klantDAO.findAll();
    }

    // Vriendenlijst van klant ophalen via id
    @GetMapping("/vrienden")
    public List<Klant> getVrienden(@RequestParam Long id) {
        Optional<Klant> klant = klantDAO.findById(id);
        return klant.map(Klant::getFriends).orElse(List.of());
    }

    // Nieuwe klant aanmaken (query params)
    @PostMapping
    public Klant maakKlant(@RequestParam String email,
                           @RequestParam String tier,
                           @RequestParam String adres) {
        Klant klant = new Klant();
        klant.setEmail(email);
        klant.setTier(tier);
        klant.setAdres(adres);
        return klantDAO.save(klant);
    }
}
