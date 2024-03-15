package dat3.cinema.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Reservation reservation;
    @OneToOne
    private Seat seat;
    private String ticketType;
    private double ticketPrice;

    public Ticket(Reservation reservation, Seat seat, String ticketType, double ticketPrice) {
        this.reservation = reservation;
        this.seat = seat;
        this.ticketType = ticketType;
        this.ticketPrice = ticketPrice;
    }
}
