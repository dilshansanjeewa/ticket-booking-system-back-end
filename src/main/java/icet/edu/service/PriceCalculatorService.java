package icet.edu.service;

import icet.edu.model.dto.PriceCalculationResult;
import icet.edu.model.entity.Event;

public interface PriceCalculatorService {
    PriceCalculationResult calculatePrice(Event event, String userType);
}
