package dat3.cinema.service;

import dat3.cinema.entity.Movie;
import dat3.cinema.repository.MovieRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    // Get all movies
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    // Get one movie
    public ResponseEntity<Movie> getOneMovie(int id) {
        return ResponseEntity.of(movieRepository.findById(id));
    }

    // Create a new movie that returns the created movie object and throws an error if the movie is not created
    public Movie createMovie(Movie request) {
        Movie movie = new Movie();
        updateMovie(movie, request);
        return movieRepository.save(movie);
    }

    // Update a movie by id and return the updated movie object or throw a 404 error if the movie is not found
    public Movie updateMovie(Movie request, int id) {
        Movie movieToEdit = movieRepository.findById(id).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie not found, can't update"));
        movieToEdit.setTitle(request.getTitle());
        movieToEdit.setGenre(request.getGenre());
        movieToEdit.setDuration(request.getDuration());
        return movieRepository.save(movieToEdit);
    }

    // Update the movie object with the given request object
    private void updateMovie(Movie movie, Movie request) {
        movie.setTitle(request.getTitle());
        movie.setGenre(request.getGenre());
        movie.setDuration(request.getDuration());
    }

    // Delete a movie by id and return the deleted movie object or throw a 404 error if the movie is not found
    public ResponseEntity<Movie> deleteOneMovie(int id) {
        Optional<Movie> movieToDelete = Optional.ofNullable(movieRepository.findById(id).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie not found, can't delete")));
        movieRepository.deleteById(id);
        return ResponseEntity.of(movieToDelete);
    }





}
