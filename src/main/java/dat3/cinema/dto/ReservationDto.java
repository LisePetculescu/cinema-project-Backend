package dat3.cinema.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import dat3.cinema.entity.Reservation;
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
    private int show_id;
    private int customer_id;
    private int total_price;
    private LocalDateTime time_stamp;
    private String ticket;
    private int ticket_amount;

    public ReservationDto(Reservation r){
        this.id = r.getId();
        this.show_id = r.getShow().getId();
        this.customer_id = r.getCustomer().getId();
        this.total_price = r.getTotal_price();
        this.time_stamp = r.getTime_stamp();
        this.ticket = r.getTicket();
        this.ticket_amount = r.getTicket_amount();
    }
}
