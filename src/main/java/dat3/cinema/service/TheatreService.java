package dat3.cinema.service;

import dat3.cinema.entity.Theatre;
import dat3.cinema.repository.TheatreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheatreService {

    private final TheatreRepository theatreRepository;

    public TheatreService(TheatreRepository theatreRepository) {
        this.theatreRepository = theatreRepository;
    }

    // Get all theatres
    public List<Theatre> getAllTheatres() {
        return theatreRepository.findAll();
    }
}
