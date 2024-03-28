package dat3.cinema.repository;

import dat3.cinema.entity.Seat;
import dat3.cinema.entity.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Integer> {

    @Query("SELECT s FROM Seat s WHERE s.theatre.id = :theatreId")
    List<Seat> findAllByTheatreId(@Param("theatreId") int theatreId);
}

