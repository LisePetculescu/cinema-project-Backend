package dat3.cinema.repository;

import dat3.cinema.entity.Show;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ShowRepository extends JpaRepository<Show, Integer>  {
}



