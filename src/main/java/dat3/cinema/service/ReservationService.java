package dat3.cinema.service;

import dat3.cinema.dto.ReservationDto;
import dat3.cinema.entity.Reservation;
import dat3.cinema.repository.ReservationRepository;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository){
        this.reservationRepository = reservationRepository;
    }

    public ReservationDto createReservation(ReservationDto request){
        Reservation newReservation = new Reservation();
        updateReservation(newReservation, request);
        reservationRepository.save(newReservation);
        return new ReservationDto(newReservation);
    }

    public void updateReservation(Reservation original, ReservationDto r){
        original.setShow(r.getShow());
        original.setCustomer(r.getCustomer());
        original.setTotalPrice(r.getTotalPrice());
        original.setTimeStamp(r.getTimeStamp());
    }
}
