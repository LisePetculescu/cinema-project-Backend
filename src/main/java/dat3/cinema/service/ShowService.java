package dat3.cinema.service;

import dat3.cinema.entity.Show;
import dat3.cinema.repository.ShowRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ShowService {

    private ShowRepository showRepository;

    public ShowService(ShowRepository showRepository) {
        this.showRepository = showRepository;
    }

    public List<Show> getAllShows() {
        return showRepository.findAll();
    }

    public ResponseEntity<Show> getOneShow( int id) {
        return ResponseEntity.of(showRepository.findById(id));
    }

    public Show createShow(Show request) {
        Show show = new Show();
        return showRepository.save(show);
    }

    public Show updateShow(Show request, int id) {
        Show showToEdit = showRepository.findById(id).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Show not found"));
        return showRepository.save(showToEdit);
    }


}
