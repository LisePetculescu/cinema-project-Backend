package dat3.cinema.entity;

// Import
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
    private boolean threeD;
    private boolean isActive;

    public Movie(String title, String description, String actors, int duration, String genre, boolean threeD, boolean isActive) {
        this.title = title;
        this.description = description;
        this.actors = actors;
        this.duration = duration;
        this.genre = genre;
        this.threeD = threeD;
        this.isActive = isActive;
    }
}


