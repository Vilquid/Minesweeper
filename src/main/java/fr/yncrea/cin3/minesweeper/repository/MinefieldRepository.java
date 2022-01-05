package fr.yncrea.cin3.minesweeper.repository;

import fr.yncrea.cin3.minesweeper.domain.Minefield;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MinefieldRepository extends JpaRepository<Minefield, UUID> {

}
