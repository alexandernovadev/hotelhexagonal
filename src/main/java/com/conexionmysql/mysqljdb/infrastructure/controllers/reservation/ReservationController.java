package com.conexionmysql.mysqljdb.infrastructure.controllers.reservation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.List;

import javax.validation.Valid;

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
import com.conexionmysql.mysqljdb.infrastructure.controllers.ErrorResponse;
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
  public ResponseEntity<?> createReservation(@RequestBody @Valid Reservation reservation) {
    try {
      createReservationService.createReservation(reservation);
      return new ResponseEntity<>(HttpStatus.CREATED);
    } catch (DateTimeParseException e) {
      ErrorResponse errorResponse = new ErrorResponse("Invalid date format. Date format should be yyyy-MM-dd HH:mm:ss",
          HttpStatus.BAD_REQUEST.value(), LocalDateTime.now());
      return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
  }

  @GetMapping
  public ResponseEntity<List<Reservation>> searchReservations(
      @RequestParam(value = "user_id", required = false) Long userId,
      @RequestParam(value = "room_id", required = false) Long roomId,
      @RequestParam(value = "reservation_state_id", required = false) Long reservationStateId,
      @RequestParam(value = "check_in_date", required = false) LocalDate checkInDate,
      @RequestParam(value = "check_out_date", required = false) LocalDate checkOutDate) {

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
