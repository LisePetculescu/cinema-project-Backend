package dat3.cinema.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "shows")
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Theatre theatre;
    @ManyToOne
    private Movie movie;
    private LocalDateTime date;
    private LocalDateTime startTime;


    public Show(Theatre theatre, Movie movie, LocalDateTime date, LocalDateTime startTime) {
        this.theatre = theatre;
        this.movie = movie;
        this.date = date;
        this.startTime = startTime;
    }


}
