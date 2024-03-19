package dat3.cinema.service;

import dat3.cinema.dto.ReservationDto;
import dat3.cinema.entity.Customer;
import dat3.cinema.entity.Reservation;
import dat3.cinema.entity.Show;
import dat3.cinema.repository.CustomerRepository;
import dat3.cinema.repository.ReservationRepository;
import dat3.cinema.repository.ShowRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    ReservationRepository reservationRepository;
    ShowRepository showRepository;

    CustomerRepository customerRepository;

    public ReservationService(ReservationRepository reservationRepository, ShowRepository showRepository, CustomerRepository customerRepository){
        this.reservationRepository = reservationRepository;
        this.showRepository = showRepository;
        this.customerRepository = customerRepository;
    }

    public List<ReservationDto> getAllReservations(){
        return reservationRepository.findAll().stream().map(ReservationDto::new).toList();
    }

    public ReservationDto getReservationById(int id){
        Reservation reservation = reservationRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Reservation not found in database"));
        return new ReservationDto(reservation);
    }

    public ReservationDto createReservation(ReservationDto request){
        Reservation newReservation = new Reservation();
        updateReservation(newReservation, request);
        reservationRepository.save(newReservation);
        return new ReservationDto(newReservation);
    }

    public void updateReservation(Reservation original, ReservationDto r){
        original.setTotal_price(r.getTotal_price());
        original.setTime_stamp(r.getTime_stamp());
        original.setTicket(r.getTicket());
        original.setTicket_amount(r.getTicket_amount());

        if (r.getShow_id() != 0) {
            Optional<Show> showOptional = showRepository.findById(r.getShow_id());
            showOptional.ifPresent(original::setShow);
        } else {
            original.setShow(null);
        }
        if (r.getCustomer_id() != 0) {
            Optional<Customer> customerOptional = customerRepository.findById(r.getCustomer_id());
            customerOptional.ifPresent(original::setCustomer);
        } else {
            original.setCustomer(null);
        }
    }


    public ReservationDto editReservation(ReservationDto request, int id){
        Reservation reservationToEdit = reservationRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Reservation not found in database")
        );
        updateReservation(reservationToEdit, request);
        reservationRepository.save(reservationToEdit);
        return new ReservationDto(reservationToEdit);

    }

    public ResponseEntity<Void> deleteReservation(int id) {
        Reservation reservationToDelete = reservationRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Reservation not found in database")
        );
        reservationRepository.delete(reservationToDelete);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
