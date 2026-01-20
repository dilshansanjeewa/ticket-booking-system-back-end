package icet.edu.service;

import icet.edu.model.dto.PriceCalculationResult;
import icet.edu.model.dto.SeatsDTO;

public interface BookingService {
    PriceCalculationResult holdSeat(Long seatId, Long userId);
}
