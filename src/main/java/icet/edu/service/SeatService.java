package icet.edu.service;

import icet.edu.model.dto.SeatsDTO;

public interface SeatService {

    SeatsDTO findById(Long seatId, Long userId);
}
