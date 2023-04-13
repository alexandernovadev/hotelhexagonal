package com.conexionmysql.mysqljdb.infrastructure.jpa.repositories;

import org.springframework.stereotype.Repository;

import com.conexionmysql.mysqljdb.infrastructure.jpa.entities.Reservation;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
       @Query("SELECT r FROM Reservation r " +
                     "WHERE (:userId is null or r.user_id.id = :userId) " +
                     "AND (:roomId is null or r.room_id.id = :roomId) " +
                     "AND (:reservationStateId is null or r.reservation_state_id.id = :reservationStateId) " +
                     "AND (:checkInDate is null or r.check_in_date >= :checkInDate) " +
                     "AND (:checkOutDate is null or r.check_out_date >= :checkOutDate)")
       List<Reservation> findByCriteria(@Param("userId") Long userId,
                     @Param("roomId") Long roomId,
                     @Param("reservationStateId") Long reservationStateId,
                     @Param("checkInDate") LocalDate checkInDate,
                     @Param("checkOutDate") LocalDate checkOutDate);

}
// @Query("SELECT r FROM Reservation r " +
// "WHERE (:userId IS NULL OR r.user_id.id = :userId) " +
// "AND (:roomId IS NULL OR r.room_id.id = :roomId) " +
// "AND (:reservationStateId IS NULL OR r.reservation_state_id.id = :reservationStateId) " +
// "AND (:checkInDate IS NULL OR r.checkInDate >= :checkInDateStart AND r.checkInDate <= :checkInDateEnd) " +
// "AND (:checkOutDate IS NULL OR r.checkOutDate >= :checkOutDateStart AND r.checkOutDate <= :checkOutDateEnd)")
