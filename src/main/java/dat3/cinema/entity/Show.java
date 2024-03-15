package dat3.cinema.entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "shows")
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int roomsId;
    private int moviesId;
    private LocalDateTime date;
    private LocalDateTime startTime;


    public Show( int roomsId, int moviesId, LocalDateTime date, LocalDateTime startTime) {
        this.roomsId = roomsId;
        this.moviesId = moviesId;
        this.date = date;
        this.startTime = startTime;
    }

    public Show() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoomsId() {
        return roomsId;
    }

    public void setRoomsId(int roomsId) {
        this.roomsId = roomsId;
    }

    public int getMoviesId() {
        return moviesId;
    }

    public void setMoviesId(int moviesId) {
        this.moviesId = moviesId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

}
