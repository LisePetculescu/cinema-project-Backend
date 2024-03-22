package dat3.cinema.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;


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
    private LocalDate date;
    private LocalTime startTime;


    public Show(Theatre theatre, Movie movie, LocalDate date, LocalTime startTime) {
        this.theatre = theatre;
        this.movie = movie;
        this.date = date;
        this.startTime = startTime;
    }

}
