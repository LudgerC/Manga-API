package be.ehb.mangaapi.Model.DAO;

import be.ehb.mangaapi.Model.Klant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface KlantDAO extends JpaRepository<Klant, Long> {
    List<Klant> findAll();
    Optional<Klant> findById(Long id);
    Klant save(Klant klant);
    void deleteById(Long id);
}
