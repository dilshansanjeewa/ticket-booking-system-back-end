package icet.edu.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString

@Entity
@Table(name = "seat")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "seat_number")
    private String seatNumber; // Using String to allow "A1", "B2" etc.

    @Column(name = "seat_status")
    private String status;

    @Column(name = "held_by_user_id")
    private Long heldByUserId; // Storing the ID directly as per your schema

    @Column(name = "hold_expiry")
    private LocalDateTime holdExpiry;

    // Foreign Key to Event
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;
}
