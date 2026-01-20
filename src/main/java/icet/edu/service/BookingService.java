package icet.edu.service;

import icet.edu.model.dto.SeatsDTO;

public interface BookingService {
    SeatsDTO holdSeat(Long seatId, Long userId);
}
