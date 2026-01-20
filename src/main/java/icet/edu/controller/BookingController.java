package icet.edu.controller;

import icet.edu.model.dto.SeatsDTO;
import icet.edu.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor

@RestController
@RequestMapping("/Booking")
public class BookingController {

    private final BookingService bookingService;

    @GetMapping("/seat/hold/{seatId}/{userId}")
    public SeatsDTO holdSeat(@PathVariable Long seatId, @PathVariable Long userId){
        SeatsDTO seatsDTO = bookingService.holdSeat(seatId, userId);
        return seatsDTO;
    }
}
