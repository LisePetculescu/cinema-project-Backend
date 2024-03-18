package dat3.cinema.entity;

import jakarta.persistence.*;
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
    private int totalPrice;
    @CreationTimestamp
    private LocalDateTime timeStamp;
    private String ticket;
    private int ticket_amount;

    public Reservation(Show show, Customer customer, int totalPrice, LocalDateTime timeStamp, String ticket, int ticket_amount) {
        this.show = show;
        this.customer = customer;
        this.totalPrice = totalPrice;
        this.timeStamp = timeStamp;
        this.ticket = ticket;
        this.ticket_amount = ticket_amount;
    }
}
