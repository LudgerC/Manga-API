package be.ehb.mangaapi.Model.DAO;

import be.ehb.mangaapi.Model.Boek;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoekDAO extends JpaRepository<Boek, Long> {

}
