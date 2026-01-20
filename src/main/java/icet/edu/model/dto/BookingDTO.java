package icet.edu.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class BookingDTO {
    private Long bookingId;
    private Long userId;
    private Double amountPaid;
    private String status;
}
