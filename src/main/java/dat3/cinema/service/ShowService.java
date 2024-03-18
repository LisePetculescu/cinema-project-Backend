package dat3.cinema.service;

import dat3.cinema.entity.Movie;
import dat3.cinema.entity.Show;
import dat3.cinema.entity.Theatre;
import dat3.cinema.repository.ShowRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

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

// create a new show and return the created show object and throw a error if the show is not created
    public Show createShow(Show request) {
        Show show = new Show();
        updateShow(show, request);
        return showRepository.save(show);
    }



// update a show  with a given id and return the updated show object or throw a 404 error if the show is not found in the database
    public Show updateShow(Show request, int id) {
        Show showToEdit = showRepository.findById(id).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Show not found, can't update"));
        showToEdit.setMovie(request.getMovie());
        showToEdit.setTheatre(request.getTheatre());
        showToEdit.setStartTime(request.getStartTime());
        return showRepository.save(showToEdit);
    }

    // delete a show with a given id and return the deleted show object or throw a 404 error if the show is not found in the database
    public ResponseEntity<Show> deleteOneShow(int id) {
        Optional<Show> showToDelete = Optional.ofNullable(showRepository.findById(id).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Show not found, can't delete")));
        showRepository.deleteById(id);
        return ResponseEntity.of(showToDelete);
    }

    private void updateShow(Show show, Show request) {
        show.setMovie(request.getMovie());
        show.setTheatre(request.getTheatre());
        show.setDate(request.getDate());
        show.setStartTime(request.getStartTime());
    }
}
