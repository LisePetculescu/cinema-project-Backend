package dat3.cinema.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Theatre theatre;
    private int lineNumber;
    private int seatNumber;

    public Seat(Theatre theatre, int lineNumber, int seatNumber) {
        this.theatre = theatre;
        this.lineNumber = lineNumber;
        this.seatNumber = seatNumber;
    }
}
