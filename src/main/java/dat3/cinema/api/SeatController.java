package dat3.cinema.api;

import dat3.cinema.entity.Seat;
import dat3.cinema.service.SeatService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seats")
public class SeatController {

    private final SeatService seatService;

    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    // Get all seats path
    @GetMapping
    public List<Seat> getAllSeats() {
        return seatService.getAllSeats();
    }

    // Get one seat path
    @GetMapping("/{id}")
    public ResponseEntity<Seat> getOneSeat(@PathVariable int id) {
        return seatService.getOneSeat(id);
    }

    // Create a new seat path
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Seat addSeat(@RequestBody Seat request) {
        return seatService.createSeat(request);
    }

    // Update a seat path
    @PutMapping(path = "/{id}")
    public Seat updateSeat(@RequestBody Seat request, @PathVariable int id) {
        return seatService.updateSeat(request, id);
    }

    //
    @DeleteMapping("/{id}")
    public ResponseEntity<Seat> deleteOneSeat(@PathVariable int id) {
        return seatService.deleteOneSeat(id);
    }
}
