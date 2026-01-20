package icet.edu.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class PriceCalculationResult {
    private BigDecimal finalPrice;
    private boolean hasPriorityAccess;
    private String note;
    private String seatType;
}