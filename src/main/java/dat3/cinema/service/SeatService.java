package dat3.cinema.service;

import dat3.cinema.entity.Seat;
import dat3.cinema.repository.SeatRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;

@Service
public class SeatService {

    private final SeatRepository seatRepository;

    public SeatService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    // Get all seats
    public List<Seat> getAllSeats() {
        return seatRepository.findAll();
    }

    // Get one seat by id
    public ResponseEntity<Seat> getOneSeat(int id) {
        return ResponseEntity.of(seatRepository.findById(id));
    }

    // Create a new seat
    public Seat createSeat(Seat request) {
        Seat seat = new Seat();
        updateSeat(seat, request);
        return seatRepository.save(seat);
    }

    // Update seat by id
    public Seat updateSeat(Seat request, int id) {
        Seat seatToEdit = seatRepository.findById(id).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Seat not found, can't update"));
        seatToEdit.setTheatre(request.getTheatre());
        seatToEdit.setLineNumber(request.getLineNumber());
        seatToEdit.setSeatNumber(request.getSeatNumber());
        return seatRepository.save(seatToEdit);
    }

    // Update the seat object with the requested object
    private void updateSeat(Seat seat, Seat request) {
        seat.setTheatre(request.getTheatre());
        seat.setLineNumber(request.getLineNumber());
        seat.setSeatNumber(request.getSeatNumber());
    }

    // Delete a seat by id
    public ResponseEntity<Seat> deleteOneSeat(int id) {
        Optional <Seat> SeatToDelete = Optional.ofNullable(seatRepository.findById(id).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Seat not found, can't delete")));
        seatRepository.deleteById(id);
        return ResponseEntity.of(SeatToDelete);
    }
}
