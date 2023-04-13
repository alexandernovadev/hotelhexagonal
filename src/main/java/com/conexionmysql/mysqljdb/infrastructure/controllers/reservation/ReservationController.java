package com.conexionmysql.mysqljdb.infrastructure.controllers.reservation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
import com.conexionmysql.mysqljdb.application.services.room.GetRoomByIdService;
import com.conexionmysql.mysqljdb.application.services.user.GetUserByIdService;
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

  @Autowired
  private GetUserByIdService getUserByIdService;

  @Autowired
  private GetRoomByIdService getRoomByIdService;

  @PostMapping
  public ResponseEntity<?> createReservation(@RequestBody @Valid Reservation reservation) {
    log.info("Creating reservation");

    // Verificar si el usuario existe, si se proporciona userId
    if (reservation.getUser_id() != null
        && getUserByIdService.getUserById(reservation.getUser_id().getUser_id()) == null) {
      ErrorResponse errorResponse = new ErrorResponse(
          "Oops, no se encontró el usuario " + reservation.getUser_id().getUser_id(),
          HttpStatus.NOT_FOUND.value(),
          LocalDateTime.now());
      return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    // Verificar si la habitación existe, si se proporciona roomId
    if (reservation.getRoom_id() != null
        && getRoomByIdService.getRoomById(reservation.getRoom_id().getRoom_id()).isEmpty()) {
      ErrorResponse errorResponse = new ErrorResponse(
          "Oops, no se encontró la habitación " + reservation.getRoom_id().getRoom_id(),
          HttpStatus.NOT_FOUND.value(),
          LocalDateTime.now());
      return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    // Verificar si las fechas son válidas
    if (reservation.getCheck_in_date() != null && reservation.getCheck_out_date() != null
        && reservation.getCheck_in_date().isAfter(reservation.getCheck_out_date())) {
      ErrorResponse errorResponse = new ErrorResponse("La fecha de check-in debe ser anterior a la fecha de check-out",
          HttpStatus.BAD_REQUEST.value(),
          LocalDateTime.now());
      return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    try {
      createReservationService.createReservation(reservation);
      ErrorResponse Response = new ErrorResponse("Se creoo bien",
          HttpStatus.IM_USED.value(),
          LocalDateTime.now());
      return new ResponseEntity<>(Response, HttpStatus.CREATED);
    } catch (DateTimeParseException e) {

      ErrorResponse errorResponse = new ErrorResponse("Invalid date format. Date format should be yyyy-MM-dd HH:mm:ss",
          HttpStatus.BAD_REQUEST.value(), LocalDateTime.now());
      return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    } catch (DataIntegrityViolationException e) {
      ErrorResponse errorResponse = new ErrorResponse("Error creating reservation: ",
          HttpStatus.BAD_REQUEST.value(), LocalDateTime.now());
      return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
  }

  
  @GetMapping
  public ResponseEntity<Object> searchReservations(
      @RequestParam(value = "user_id", required = false) Long userId,
      @RequestParam(value = "room_id", required = false) Long roomId,
      @RequestParam(value = "reservation_state_id", required = false) Long reservationStateId,
      @RequestParam(value = "check_in_date", required = false) String checkInDateString,
      @RequestParam(value = "check_out_date", required = false) String checkOutDateString) {

    log.info("Searching reservations with filters");

    // Check if user exists
    if (userId != null && getUserByIdService.getUserById(userId) == null) {
      ErrorResponse errorResponse = new ErrorResponse("Oops, no se encontró el usuario " + userId,
          HttpStatus.NOT_FOUND.value(),
          LocalDateTime.now());
      return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    // Check if room exists
    if (roomId != null && getRoomByIdService.getRoomById(roomId).isEmpty()) {
      ErrorResponse errorResponse = new ErrorResponse("Oops, no se encontró la habitación " + roomId,
          HttpStatus.NOT_FOUND.value(),
          LocalDateTime.now());
      return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    LocalDateTime checkInDate = null;
    LocalDateTime checkOutDate = null;

    // Parse check-in date
    if (checkInDateString != null) {
      try {
        checkInDate = LocalDate.parse(checkInDateString).atStartOfDay();
      } catch (DateTimeParseException e) {
        ErrorResponse errorResponse = new ErrorResponse(
            "Invalid check-in date format. Date format should be yyyy-MM-dd",
            HttpStatus.BAD_REQUEST.value(), LocalDateTime.now());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
      }
    }

    // Parse check-out date
    if (checkOutDateString != null) {
      try {
        checkOutDate = LocalDate.parse(checkOutDateString).atStartOfDay();
      } catch (DateTimeParseException e) {
        ErrorResponse errorResponse = new ErrorResponse(
            "Invalid check-out date format. Date format should be yyyy-MM-dd",
            HttpStatus.BAD_REQUEST.value(), LocalDateTime.now());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
      }
    }

    // Check if dates are valid
    if (checkInDate != null && checkOutDate != null && checkInDate.isAfter(checkOutDate)) {
      ErrorResponse errorResponse = new ErrorResponse("La fecha de check-in debe ser anterior a la fecha de check-out",
          HttpStatus.BAD_REQUEST.value(),
          LocalDateTime.now());
      return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    ReservationSearchDto reservationSearchDto = new ReservationSearchDto();
    reservationSearchDto.setUserId(userId);
    reservationSearchDto.setRoomId(roomId);
    reservationSearchDto.setReservationStateId(reservationStateId);
    reservationSearchDto.setCheckInDate(checkInDate);
    reservationSearchDto.setCheckOutDate(checkOutDate);

    try {
      List<Reservation> reservations = searchReservationService.searchReservations(reservationSearchDto);
      return new ResponseEntity<>(reservations, HttpStatus.OK);
    } catch (Exception e) {
      ErrorResponse errorResponse = new ErrorResponse("Error searching reservations",
          HttpStatus.INTERNAL_SERVER_ERROR.value(),
          LocalDateTime.now());
      return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
