package be.ehb.mangaapi.Model.DAO;

import be.ehb.mangaapi.Model.Boek;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoekDAO extends JpaRepository<Boek, Long> {
    List<Boek> findByGenre(String genre);
}
