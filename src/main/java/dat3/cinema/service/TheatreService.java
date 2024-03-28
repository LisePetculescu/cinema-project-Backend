package dat3.cinema.service;

import dat3.cinema.entity.Seat;
import dat3.cinema.entity.Theatre;
import dat3.cinema.repository.TheatreRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheatreService {

    private TheatreRepository theatreRepository;

    public TheatreService(TheatreRepository theatreRepository) {
        this.theatreRepository = theatreRepository;
    }

    public List<Theatre> getAllTheatres() {
        return theatreRepository.findAll();
    }

    //Get all seats from a theatre
    public  List<Seat> getAllSeatsOfTheatre(int id){
        return theatreRepository.findAllByTheatreId(id);
    }

    public ResponseEntity<Theatre> getOneTheatre(int id) {
        return ResponseEntity.of(theatreRepository.findById(id));
    }
}
