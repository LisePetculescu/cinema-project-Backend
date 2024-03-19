package dat3.cinema.service;

import dat3.cinema.entity.Movie;
import dat3.cinema.repository.MovieRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public ResponseEntity<Movie> getOneMovie(int id) {
        return ResponseEntity.of(movieRepository.findById(id));
    }

}
