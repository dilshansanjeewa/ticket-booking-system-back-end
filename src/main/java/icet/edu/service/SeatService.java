package icet.edu.service;

import icet.edu.model.entity.Seat;

public interface SeatService {

    Seat findById(Long seatId, Long userId);
}
