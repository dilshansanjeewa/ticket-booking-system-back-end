package icet.edu.service.impl;

import icet.edu.model.dto.PriceCalculationResult;
import icet.edu.model.entity.Event;
import icet.edu.service.PriceCalculatorService;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class PriceCalculatorServiceImpl implements PriceCalculatorService {

    @Override
    public PriceCalculationResult calculatePrice(Event event, String userType) {

        // Start with the Base Price
        BigDecimal finalPrice =BigDecimal.valueOf(event.getBasePrice());
        boolean hasPriorityAccess = false;
        String note = "Standard Rate";

        switch (userType) {
            case "VIP":
                if (event.isHighDemand()) {
                    note = "High Demand Event: VIP Discount skipped.";
                } else {
                    finalPrice = finalPrice.multiply(new BigDecimal("0.90"));
                    note = "VIP Discount Applied (10% off).";
                }
                break;

            case "PLATINUM":
                hasPriorityAccess = true;
                note = "Platinum Status: Priority Access Granted.";
                break;

            case "REGULAR":
            default:
                note = "Regular Ticket Price.";
                break;
        }

        finalPrice = finalPrice.setScale(2, RoundingMode.HALF_UP);

        return new PriceCalculationResult(finalPrice, hasPriorityAccess, note,null);
    }
}