package dat3.cinema.api;

import dat3.cinema.dto.ReservationDto;
import dat3.cinema.entity.Reservation;
import dat3.cinema.service.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
//@CrossOrigin("")
public class ReservationController {

    ReservationService reservationService;

    public ReservationController(ReservationService reservationService){
        this.reservationService = reservationService;
    }
    
    @GetMapping
    public List<ReservationDto> getAllReservations(){
        return reservationService.getAllReservations();
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
