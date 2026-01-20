package icet.edu.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString

@Entity
@Table(name = "event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "base_price")
    private Double basePrice;

    @Column(name = "is_high_demand")
    private boolean isHighDemand;

    @Column(name = "event_date")
    private LocalDate eventDate;

    // Relationship: One Event owns many Seats
    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Seat> seats;
}
