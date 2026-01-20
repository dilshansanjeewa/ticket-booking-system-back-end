package icet.edu.model.dto;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString

public class SeatsDTO {
    private Long id;
    private String seatNumber;
    private String status;
    private Double finalPrice; // Calculated!
    private LocalDateTime holdExpiry;
}
