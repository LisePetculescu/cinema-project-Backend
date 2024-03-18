package dat3.cinema.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Show show;
    @ManyToOne
    private Customer customer;
    private int total_price;
    @CreationTimestamp
    private LocalDateTime time_stamp;
    private String ticket;
    private int ticket_amount;

    public Reservation(Show show, Customer customer, int total_price, LocalDateTime time_stamp, String ticket, int ticket_amount) {
        this.show = show;
        this.customer = customer;
        this.total_price = total_price;
        this.time_stamp = time_stamp;
        this.ticket = ticket;
        this.ticket_amount = ticket_amount;
    }
}
