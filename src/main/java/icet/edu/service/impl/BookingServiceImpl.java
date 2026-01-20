package icet.edu.service.impl;

import icet.edu.model.dto.SeatsDTO;
import icet.edu.model.entity.Event;
import icet.edu.model.entity.Seat;
import icet.edu.service.BookingService;
import icet.edu.service.SeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor

@Service
public class BookingServiceImpl implements BookingService {

    private final SeatService seatService;

    @Override
    public SeatsDTO holdSeat(Long seatId, Long userId) {
        SeatsDTO seat= seatService.findById(seatId, userId);
        return null;
    }
}
