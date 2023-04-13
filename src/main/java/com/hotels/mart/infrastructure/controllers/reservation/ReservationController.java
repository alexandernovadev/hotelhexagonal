package com.hotels.mart.infrastructure.controllers.reservation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.List;

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

import com.hotels.mart.application.dto.ReservationCreateDto;
import com.hotels.mart.application.dto.ReservationSearchDto;
import com.hotels.mart.application.dto.ResponseFormat;
import com.hotels.mart.application.services.reservation.CreateReservationService;
import com.hotels.mart.application.services.reservation.SearchReservationService;
import com.hotels.mart.application.services.reservationState.SearcReservationStateByIdService;
import com.hotels.mart.application.services.room.GetRoomByIdService;
import com.hotels.mart.application.services.user.GetUserByIdService;
import com.hotels.mart.domain.entities.Reservation;

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

  @Autowired
  private SearcReservationStateByIdService searcReservationStateByIdService;

  @PostMapping
  public ResponseEntity<?> createReservation(@RequestBody @Valid ReservationCreateDto reservation) {
    log.info("Creating reservation");

    var response = createReservationService.createReservation(reservation);
    return new ResponseEntity<>(response, HttpStatus.CREATED);

  }

  @GetMapping
  public ResponseEntity<Object> searchReservations(
      @RequestParam(value = "reservation_id", required = false) Long reservation_id,
      @RequestParam(value = "user_id", required = false) Long userId,
      @RequestParam(value = "room_id", required = false) Long roomId,
      @RequestParam(value = "reservation_state_id", required = false) Long reservationStateId,
      @RequestParam(value = "check_in_date", required = false) String checkInDateString,
      @RequestParam(value = "check_out_date", required = false) String checkOutDateString) {

    log.info("Searching reservations with filters");

    // Check if user exists
    if (userId != null && getUserByIdService.getUserById(userId) == null) {
      ResponseFormat responseFormat = new ResponseFormat("Oops, no se encontró el usuario " + userId,
          HttpStatus.NOT_FOUND.value(),
          LocalDateTime.now());
      return new ResponseEntity<>(responseFormat, HttpStatus.NOT_FOUND);
    }

    // Check if room exists
    if (roomId != null && getRoomByIdService.getRoomById(roomId).isEmpty()) {
      ResponseFormat errorResponse = new ResponseFormat("Oops, no se encontró la habitación " + roomId,
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
        ResponseFormat errorResponse = new ResponseFormat(
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
        ResponseFormat errorResponse = new ResponseFormat(
            "Invalid check-out date format. Date format should be yyyy-MM-dd",
            HttpStatus.BAD_REQUEST.value(), LocalDateTime.now());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
      }
    }

    // Check if dates are valid
    if (checkInDate != null && checkOutDate != null && checkInDate.isAfter(checkOutDate)) {
      ResponseFormat errorResponse = new ResponseFormat(
          "La fecha de check-in debe ser anterior a la fecha de check-out",
          HttpStatus.BAD_REQUEST.value(),
          LocalDateTime.now());
      return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    ReservationSearchDto reservationSearchDto = new ReservationSearchDto();
    reservationSearchDto.setReservationId(reservation_id);
    reservationSearchDto.setUserId(userId);
    reservationSearchDto.setRoomId(roomId);
    reservationSearchDto.setReservationStateId(reservationStateId);
    reservationSearchDto.setCheckInDate(checkInDate);
    reservationSearchDto.setCheckOutDate(checkOutDate);

    List<Reservation> reservations = searchReservationService.searchReservations(reservationSearchDto);
    
    
    return new ResponseEntity<>(reservations, HttpStatus.OK);

  }

}
