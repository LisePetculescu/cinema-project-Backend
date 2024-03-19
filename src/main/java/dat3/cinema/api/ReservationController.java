package dat3.cinema.api;

import dat3.cinema.dto.ReservationDto;
import dat3.cinema.entity.Reservation;
import dat3.cinema.repository.ReservationRepository;
import dat3.cinema.service.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/reservations")
//@CrossOrigin("")
public class ReservationController {

    ReservationService reservationService;
    ReservationRepository reservationRepository;

    public ReservationController(ReservationService reservationService, ReservationRepository reservationRepository){
        this.reservationService = reservationService;
        this.reservationRepository = reservationRepository;
    }

    @GetMapping
    public List<ReservationDto> getAllReservations(){
        return reservationService.getAllReservations();
    }

    @GetMapping(path = "/id")
    public ReservationDto getReservationById(int id){
        Reservation reservation = reservationRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Reservation not found in database"));
        return new ReservationDto(reservation);
    }

    @PostMapping
    public ReservationDto createReservation(@RequestBody ReservationDto request){
        return reservationService.createReservation(request);
    }

    @PutMapping(path = "/{id}")
    public ReservationDto updateReservation(@RequestBody ReservationDto request, @PathVariable int id){
        return reservationService.editReservation(request, id);
    }

}
