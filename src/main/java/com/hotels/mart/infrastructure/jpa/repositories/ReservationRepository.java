package com.hotels.mart.infrastructure.jpa.repositories;

import org.springframework.stereotype.Repository;

import com.hotels.mart.domain.entities.Reservation;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    @Query("SELECT r FROM Reservation r " +
    "WHERE (:reservationId is null or r.id = :reservationId) " +
    "AND (:userId is null or r.user_id.id = :userId) " +
    "AND (:roomId is null or r.room_id.id = :roomId) " +
    "AND (:reservationStateId is null or r.reservation_state_id.id = :reservationStateId) " +
    "AND ((:checkInDate is null and :checkOutDate is null) " +
    "   or (:checkInDate is null and r.check_out_date >= :checkOutDate) " +
    "   or (:checkOutDate is null and r.check_in_date >= :checkInDate) " +
    "   or (r.check_in_date <= :checkOutDate and r.check_out_date >= :checkInDate))")
    List<Reservation> findByCriteria(
            @Param("reservationId") Long reservationId,
            @Param("userId") Long userId,
            @Param("roomId") Long roomId,
            @Param("reservationStateId") Long reservationStateId,
            @Param("checkInDate") LocalDateTime checkInDate,
            @Param("checkOutDate") LocalDateTime checkOutDate);

}
