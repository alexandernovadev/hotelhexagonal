package com.conexionmysql.mysqljdb.infrastructure.controllers.reservation;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.conexionmysql.mysqljdb.application.dto.ReservationCreateDto;
import com.conexionmysql.mysqljdb.application.dto.ReservationSearchDto;
import com.conexionmysql.mysqljdb.application.services.reservation.CreateReservationService;
import com.conexionmysql.mysqljdb.application.services.reservation.SearchReservationService;
import com.conexionmysql.mysqljdb.infrastructure.jpa.entities.Reservation;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/reservations")
@Slf4j
public class ReservationController {

  @Autowired
  private CreateReservationService createReservationService;

  @Autowired
  private SearchReservationService searchReservationService;

  @PostMapping
  public ResponseEntity<?> createReservation(@RequestBody Reservation reservation) {
    log.info("Creating reservation", reservation);
    createReservationService.createReservation(reservation);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }
  // Get reservations filtered by date, id, etc

  @GetMapping
  public ResponseEntity<List<Reservation>> searchReservations(
      @RequestParam(value = "userId", required = false) Long userId,
      @RequestParam(value = "roomId", required = false) Long roomId,
      @RequestParam(value = "reservationStateId", required = false) Long reservationStateId,
      @RequestParam(value = "checkInDate", required = false) LocalDate checkInDate,
      @RequestParam(value = "checkOutDate", required = false) LocalDate checkOutDate) {

    log.info("Searching reservations with filters");

    ReservationCreateDto reservationCreateDto = new ReservationCreateDto();
    reservationCreateDto.setUser_id(userId);
    reservationCreateDto.setRoom_id(roomId);
    reservationCreateDto.setReservation_state_id(reservationStateId);
    reservationCreateDto.setCheck_in_date(checkInDate);
    reservationCreateDto.setCheck_out_date(checkOutDate);
    
    List<Reservation> reservations = searchReservationService.searchReservations(reservationCreateDto);

    return new ResponseEntity<>(reservations, HttpStatus.OK);
  }

}
