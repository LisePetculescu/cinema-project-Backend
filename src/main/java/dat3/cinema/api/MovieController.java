package dat3.cinema.api;

import dat3.cinema.entity.Movie;
import dat3.cinema.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    // Get all movies path
    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    // Get one movie path
    @GetMapping(path = "/{id}")
    public ResponseEntity<Movie> getOneMovie(@PathVariable int id) {
        return movieService.getOneMovie(id);
    }

    // Create a new movie path
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Movie addMovie(@RequestBody Movie request) {
        return movieService.createMovie(request);
    }

    // Update a movie path
    @PutMapping(path = "/{id}")
    public Movie updateMovie(@RequestBody Movie request, @PathVariable int id) {
        return movieService.updateMovie(request, id);
    }

    // Delete a movie path
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Movie> deleteOneMovie(@PathVariable int id) {
        return movieService.deleteOneMovie(id);
    }

















}
