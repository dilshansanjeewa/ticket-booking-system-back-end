package icet.edu.service.impl;

import icet.edu.annotation.AuditFailure;
import icet.edu.model.dto.SeatsDTO;
import icet.edu.model.entity.Seat;
import icet.edu.repository.SeatRepository;
import icet.edu.service.SeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor

@Service
public class SeatServiceImpl implements SeatService {

    private final SeatRepository seatRepository;

    private static final int HOLD_DURATION = 10;

    @AuditFailure
    @Override
    public Seat findById(Long seatId, Long userId) {
        Seat seat = seatRepository.findById(seatId).orElseThrow(() -> new RuntimeException("Seat not Found"));
        if (seat.getStatus().equals("SOLD")) {
            throw new RuntimeException("Seat is already sold.");
        }

        if (seat.getStatus().equals("HELD")) {
            throw new RuntimeException("Seat is currently held by another user.");
        }

        seat.setStatus("HELD");
        seat.setHeldByUserId(userId);

        seat.setHoldExpiry(LocalDateTime.now().plusMinutes(HOLD_DURATION));

        Seat savedSeat = seatRepository.save(seat);

        SeatsDTO seatsDTO = new SeatsDTO(
                seat.getId(),
                seat.getSeatNumber(),
                seat.getStatus(),
                seat.getEvent().getBasePrice(),
                seat.getHoldExpiry()
        );
        return seat;
    }

    @Scheduled(fixedRate = 60000)
    public void releaseExpiredHolds() {
        LocalDateTime now = LocalDateTime.now();
        List<Seat> expiredSeats = seatRepository.findByStatusAndHoldExpiryBefore(
                "HELD", now
        );

        if (!expiredSeats.isEmpty()) {
            for (Seat seat : expiredSeats) {
                seat.setStatus("AVAILABLE");
                seat.setHeldByUserId(null);
                seat.setHoldExpiry(null);
            }
            seatRepository.saveAll(expiredSeats);
            System.out.println("Cleaned up " + expiredSeats.size() + " seats.");
        }
    }
}
