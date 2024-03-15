package dat3.cinema.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import dat3.cinema.entity.Customer;
import dat3.cinema.entity.Reservation;
import dat3.cinema.entity.Show;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReservationDto {
    private int id;
    private Show show;
    private Customer customer;
    private int totalPrice;
    private LocalDateTime timeStamp;

    public ReservationDto(Reservation r){
        this.id = r.getId();
        this.show = r.getShow();
        this.customer = r.getCustomer();
        this.totalPrice = r.getTotalPrice();
        this.timeStamp = r.getTimeStamp();
    }
}
