package icet.edu.model.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString

@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // "user_id" - Stored as a raw ID (Loose coupling)
    @Column(name = "user_id", nullable = false)
    private Long userId;

    // "amount_paid"
    @Column(name = "amount_paid", nullable = false)
    private Double amountPaid;

    @Column(nullable = false)
    private String status;

    // "seat_id" - Relationship to the Seat Entity
    // Many bookings can theoretically exist for one seat (e.g., historical cancelled bookings)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seat_id", nullable = false)
    private Seat seat;

}
