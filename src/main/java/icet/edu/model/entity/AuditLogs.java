package icet.edu.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString

@Entity
@Table(name = "audit_logs")
public class AuditLogs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String action;

    @Column(name = "user_id")
    private Long userId;
    private String details;

    @Column(name = "time_stamp")
    private Instant timestamp;
}
