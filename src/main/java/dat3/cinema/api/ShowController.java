package dat3.cinema.api;

import dat3.cinema.entity.Show;
import dat3.cinema.service.ShowService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;

@RestController
@RequestMapping("/shows")
public class ShowController {

    private ShowService showService;

    public ShowController(ShowService showService) {
        this.showService = showService;
    }

    @GetMapping
    public List<Show> getAllShows() {
        return showService.getAllShows();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Show> getOneShow(@PathVariable int id) {
        return showService.getOneShow(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Show addShow(@RequestBody Show request) {
        return showService.createShow(request);
    }

    @PutMapping(path = "/{id}")
    public Show updateShow(@RequestBody Show request, @PathVariable int id) {
        return showService.updateShow(request, id);
    }

}

