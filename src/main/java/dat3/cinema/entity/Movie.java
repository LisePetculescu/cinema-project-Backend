package dat3.cinema.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;
    private String actors;
    private int duration;
    private String genre;
    private boolean is3D;
    private boolean isActive;

    public Movie(String title, String description, String actors, int duration, String genre, boolean is3D, boolean isActive) {
        this.title = title;
        this.description = description;
        this.actors = actors;
        this.duration = duration;
        this.genre = genre;
        this.is3D = is3D;
        this.isActive = isActive;
    }
}


