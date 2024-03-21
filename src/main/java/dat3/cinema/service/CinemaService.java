package dat3.cinema.service;

import dat3.cinema.entity.Cinema;
import dat3.cinema.repository.CinemaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaService {

    private final CinemaRepository cinemaRepository;

    public CinemaService(CinemaRepository cinemaRepository) {
        this.cinemaRepository = cinemaRepository;
    }

    // Get all cinemas
    public List<Cinema> getAllCinemas() {
        return cinemaRepository.findAll();
    }

}
