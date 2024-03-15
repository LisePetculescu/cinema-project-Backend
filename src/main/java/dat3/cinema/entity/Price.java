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
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double ticketCheap;
    private double ticketMedium;
    private double ticketExpensive;
    private double feeExpedition;
    private double fee3D;
    private double feeLongDuration;
    private int discountGroup;

    public Price(double ticketCheap, double ticketMedium, double ticketExpensive, double feeExpedition, double fee3D, double feeLongDuration, int discountGroup) {
        this.ticketCheap = ticketCheap;
        this.ticketMedium = ticketMedium;
        this.ticketExpensive = ticketExpensive;
        this.feeExpedition = feeExpedition;
        this.fee3D = fee3D;
        this.feeLongDuration = feeLongDuration;
        this.discountGroup = discountGroup;
    }
}
