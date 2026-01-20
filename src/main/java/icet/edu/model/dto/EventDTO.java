package icet.edu.model.dto;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class EventDTO {
    private Long id;
    private String name;
    private Double basePrice;
    private boolean is_high_demand;
    private LocalDate eventDate;
}
