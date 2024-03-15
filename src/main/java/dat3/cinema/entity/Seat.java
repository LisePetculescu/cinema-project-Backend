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
    private int rowNumber;
    private int seatNumber;

    public Seat(Theatre theatre, int rowNumber, int seatNumber) {
        this.theatre = theatre;
        this.rowNumber = rowNumber;
        this.seatNumber = seatNumber;
    }
}
