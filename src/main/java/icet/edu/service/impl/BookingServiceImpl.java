package icet.edu.service.impl;

import icet.edu.annotation.AuditFailure;
import icet.edu.model.dto.PriceCalculationResult;
import icet.edu.model.dto.SeatsDTO;
import icet.edu.model.entity.Seat;
import icet.edu.model.entity.User;
import icet.edu.service.BookingService;
import icet.edu.service.PriceCalculatorService;
import icet.edu.service.SeatService;
import icet.edu.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor

@Service
public class BookingServiceImpl implements BookingService {

    private final SeatService seatService;
    private final UserService userService;
    private final PriceCalculatorService priceCalculatorService;

    @AuditFailure
    @Override
    public PriceCalculationResult holdSeat(Long seatId, Long userId) {

//        return seatService.findById(seatId, userId);
        User user = userService.findById(userId);
        Seat seat = seatService.findById(seatId, userId);

        PriceCalculationResult priceCalculationResult = priceCalculatorService.calculatePrice(seat.getEvent(), user.getTitle());
        priceCalculationResult.setSeatType(seat.getSeatNumber());

        return priceCalculationResult;

    }
}
