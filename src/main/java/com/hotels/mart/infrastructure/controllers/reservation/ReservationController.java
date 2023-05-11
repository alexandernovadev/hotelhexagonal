package com.hotels.mart.infrastructure.controllers.reservation;

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

import com.hotels.mart.application.dto.ReservationCreateDto;

import com.hotels.mart.application.dto.ResponseFormat;
import com.hotels.mart.application.services.reservation.CreateReservationService;
import com.hotels.mart.application.services.reservation.SearchReservationService;

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

    ResponseFormat reservations = searchReservationService.searchReservations(reservation_id, userId,
        roomId, reservationStateId, checkInDateString, checkOutDateString);

    return new ResponseEntity<>(reservations, HttpStatus.OK);

  }

}
