package com.hotels.mart.application.services.reservation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hotels.mart.application.dto.ReservationSearchDto;
import com.hotels.mart.application.dto.ResponseFormat;
import com.hotels.mart.application.services.emails.EmailService;
import com.hotels.mart.application.services.room.GetRoomByIdService;
import com.hotels.mart.application.services.user.GetUserByIdService;
import com.hotels.mart.domain.entities.Reservation;
import com.hotels.mart.infrastructure.jpa.repositories.ReservationRepository;

@Service
public class SearchReservationService {

  @Autowired
  private EmailService emailService;

  @Autowired
  private GetUserByIdService getUserByIdService;

  @Autowired
  private GetRoomByIdService getRoomByIdService;

  @Autowired
  private ReservationRepository reservationRepository;

  public ResponseFormat searchReservations(Long reservation_id, Long userId, Long roomId, Long reservationStateId,
      String checkInDateString, String checkOutDateString) {

    // Check if user exists
    if (userId != null && getUserByIdService.getUserById(userId) == null) {
      ResponseFormat responseFormat = new ResponseFormat("Oops, no se encontró el usuario " + userId,
          HttpStatus.NOT_FOUND.value(),
          LocalDateTime.now());
      return responseFormat;
    }

    // Check if room exists
    if (roomId != null && getRoomByIdService.getRoomById(roomId).isEmpty()) {
      ResponseFormat responseFormat = new ResponseFormat("Oops, no se encontró la habitación " + roomId,
          HttpStatus.NOT_FOUND.value(),
          LocalDateTime.now());
      return responseFormat;
    }

    LocalDateTime checkInDate = null;
    LocalDateTime checkOutDate = null;

    // Parse check-in date
    if (checkInDateString != null) {
      try {
        checkInDate = LocalDate.parse(checkInDateString).atStartOfDay();
      } catch (DateTimeParseException e) {
        ResponseFormat responseFormat = new ResponseFormat(
            "Invalid check-in date format. Date format should be yyyy-MM-dd",
            HttpStatus.BAD_REQUEST.value(), LocalDateTime.now());
        return responseFormat;
      }
    }

    // Parse check-out date
    if (checkOutDateString != null) {
      try {
        checkOutDate = LocalDate.parse(checkOutDateString).atStartOfDay();
      } catch (DateTimeParseException e) {
        ResponseFormat responseFormat = new ResponseFormat(
            "Invalid check-out date format. Date format should be yyyy-MM-dd",
            HttpStatus.BAD_REQUEST.value(), LocalDateTime.now());
        return responseFormat;
      }
    }

    // Check if dates are valid
    if (checkInDate != null && checkOutDate != null && checkInDate.isAfter(checkOutDate)) {
      ResponseFormat responseFormat = new ResponseFormat(
          "La fecha de check-in debe ser anterior a la fecha de check-out",
          HttpStatus.BAD_REQUEST.value(),
          LocalDateTime.now());
      return responseFormat;
    }
    // prueba daniel
    ReservationSearchDto reservationSearchDto = new ReservationSearchDto();
    reservationSearchDto.setReservationId(reservation_id);
    reservationSearchDto.setUserId(userId);
    reservationSearchDto.setRoomId(roomId);
    reservationSearchDto.setReservationStateId(reservationStateId);
    reservationSearchDto.setCheckInDate(checkInDate);
    reservationSearchDto.setCheckOutDate(checkOutDate);

    List<Reservation> data = reservationRepository.findByCriteria(
        reservationSearchDto.getReservationId(),
        reservationSearchDto.getUserId(),
        reservationSearchDto.getRoomId(),
        reservationSearchDto.getReservationStateId(),
        reservationSearchDto.getCheckInDate(),
        reservationSearchDto.getCheckOutDate());

    var response = emailService.sendEmail("andresolano34@gmail.com",
        "daolano58@ucatolica.edu.co", "Hotel Smart ha realizado su consulta exitosamente", "Ha buscado una reserva ");


    ResponseFormat responseFormat = new ResponseFormat(
        "Datos filtrados",
        HttpStatus.ACCEPTED.value(),
        LocalDateTime.now(),
        data);
        
    return responseFormat;

  }

  public List<Reservation> searchReservationeasy(ReservationSearchDto reservationCreateDto) {

    return reservationRepository.findByCriteria(
        reservationCreateDto.getReservationId(),
        reservationCreateDto.getUserId(),
        reservationCreateDto.getRoomId(),
        reservationCreateDto.getReservationStateId(),
        reservationCreateDto.getCheckInDate(),
        reservationCreateDto.getCheckOutDate());

  }
}
