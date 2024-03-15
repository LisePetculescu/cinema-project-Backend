package dat3.cinema.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Theatre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Cinema cinema;
    private String name;

    public Theatre(Cinema cinema, String name) {
        this.cinema = cinema;
        this.name = name;
    }
}
