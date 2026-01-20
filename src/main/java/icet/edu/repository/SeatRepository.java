package icet.edu.repository;

import icet.edu.model.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
    // "Find seats where Status is HELD AND HoldExpiry is before Now"
    List<Seat> findByStatusAndHoldExpiryBefore(String status, LocalDateTime now);
}
