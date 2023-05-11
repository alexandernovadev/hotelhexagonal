package com.hotels.mart.application.services.reservation;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hotels.mart.application.dto.ReservationCreateDto;
import com.hotels.mart.application.dto.ReservationSearchDto;
import com.hotels.mart.application.dto.ResponseFormat;
import com.hotels.mart.application.services.reservationState.SearcReservationStateByIdService;
import com.hotels.mart.application.services.room.GetRoomByIdService;
import com.hotels.mart.application.services.room.SearchRoomStateByIdService;
import com.hotels.mart.application.services.room.UpdateRoomService;
import com.hotels.mart.application.services.traceability.GotraceabilityService;
import com.hotels.mart.application.services.user.GetUserByIdService;
import com.hotels.mart.application.strategies.PrintPdfStrategy;
import com.hotels.mart.application.strategies.SaveToDatabaseStrategy;
import com.hotels.mart.domain.entities.Reservation;
import com.hotels.mart.domain.entities.Room;
import com.hotels.mart.domain.entities.Traceability;
import com.hotels.mart.infrastructure.jpa.repositories.ReservationRepository;

@Service
public class CreateReservationService {

  @Autowired
  private ReservationRepository reservationRepository;

  @Autowired
  private SearchReservationService searchReservationService;

  @Autowired
  private GetUserByIdService getUserByIdService;

  @Autowired
  private GetRoomByIdService getRoomByIdService;

  @Autowired
  private UpdateRoomService updateRoomService;

  @Autowired
  private SearcReservationStateByIdService searcReservationStateByIdService;
  @Autowired
  private SearchRoomStateByIdService searchRoomStateByIdService;

  // Here trace
  @Autowired
  private GotraceabilityService gotraceabilityService;

  @Autowired
  private SaveToDatabaseStrategy saveToDatabaseStrategy;

  @Autowired
  private PrintPdfStrategy printPdfStrategy;

  public ResponseFormat createReservation(@Valid ReservationCreateDto reservation) {

    LocalDateTime checkInDate = null;
    LocalDateTime checkOutDate = null;

    // VALIDATE IF reservation.getCheck_in_date() has a valid date format
    try {
      checkInDate = LocalDateTime.parse(reservation.getCheck_in_date());
      checkOutDate = LocalDateTime.parse(reservation.getCheck_out_date());
    } catch (DateTimeParseException e) {
      ResponseFormat responseFormat = new ResponseFormat(
          "Error: La fecha de check-in o check-out tiene un formato inválido. \n Format Valid: (yyyy-mm-dd 00:00:00)",
          HttpStatus.BAD_REQUEST.value(),
          LocalDateTime.now());
      return responseFormat;
    }

    // Verificar si el usuario existe, si se proporciona userId
    var user = getUserByIdService.getUserById(reservation.getUser_id().getUser_id());
    if (reservation.getUser_id() != null
        && user == null) {
      ResponseFormat responseFormat = new ResponseFormat(
          "Oops, no se encontró el usuario " + reservation.getUser_id().getUser_id(),
          HttpStatus.NOT_FOUND.value(),
          LocalDateTime.now());
      return responseFormat;
    }
    // TODO: Verificar si el usuario tiene permisos para reservar

    // Verificar if reservation_state_id existe
    if (reservation.getReservation_state_id() != null
        && searcReservationStateByIdService
            .searchById(reservation.getReservation_state_id().getReservation_state_id()) == null) {
      ResponseFormat responseFormat = new ResponseFormat(
          "Oops, no se encontró el estado de la reserva "
              + reservation.getReservation_state_id().getReservation_state_id(),
          HttpStatus.NOT_FOUND.value(),
          LocalDateTime.now());
      return responseFormat;
    }

    var rooms = getRoomByIdService.getRoomById(reservation.getRoom_id().getRoom_id());

    // Validate if user has reservation with the same room and dates
    ReservationSearchDto reservationSearchDto = new ReservationSearchDto();
    reservationSearchDto.setUserId(reservation.getUser_id().getUser_id());
    reservationSearchDto.setRoomId(reservation.getRoom_id().getRoom_id());
    reservationSearchDto.setReservationStateId(reservation.getReservation_state_id().getReservation_state_id());
    reservationSearchDto.setCheckInDate(checkInDate);
    reservationSearchDto.setCheckOutDate(checkOutDate);

    var reservations = searchReservationService.searchReservationeasy(reservationSearchDto);

    if (!reservations.isEmpty()) {
      ResponseFormat responseFormat = new ResponseFormat(
          "El usuario ya tiene una reserva para la habitación " + rooms.get().getName() + " !",
          HttpStatus.BAD_REQUEST.value(),
          LocalDateTime.now());
      return responseFormat;
    }

    // Verificar si la habitación existe, si se proporciona roomId

    if (reservation.getRoom_id() != null
        && rooms.isEmpty()) {
      ResponseFormat responseFormat = new ResponseFormat(
          "Oops, no se encontró la habitación " + reservation.getRoom_id().getRoom_id(),
          HttpStatus.NOT_FOUND.value(),
          LocalDateTime.now());
      return responseFormat;
    }

    // Si existe la room verificar que este en estado disponible
    if (reservation.getRoom_id() != null
        && rooms.get()
            .getState_room_id().getRooms_state_id() != 1) {
      ResponseFormat responseFormat = new ResponseFormat(
          "Oops, la habitación " + reservation.getRoom_id().getRoom_id() + " no está disponible",
          HttpStatus.BAD_REQUEST.value(),
          LocalDateTime.now());
      return responseFormat;
    }

    // Verificar si las fechas son válidas
    if (reservation.getCheck_in_date() != null && reservation.getCheck_out_date() != null
        && checkInDate.isAfter(checkOutDate)) {
      ResponseFormat responseFormat = new ResponseFormat(
          "La fecha de check-in debe ser anterior a la fecha de check-out",
          HttpStatus.BAD_REQUEST.value(),
          LocalDateTime.now());
      return responseFormat;
    }

    // Save reservation
    Reservation r = new Reservation();
    r.setCheck_in_date(checkInDate);
    r.setCheck_out_date(checkOutDate);
    r.setReservation_state_id(reservation.getReservation_state_id());
    r.setRoom_id(reservation.getRoom_id());
    r.setUser_id(reservation.getUser_id());

    reservationRepository.save(r);

    // Si la reservation se crea con éxito, cambiar el estado de la habitación a
    // reservada
    var reservedState = searchRoomStateByIdService.getRoomState(5L);

    Room newroom = new Room();
    newroom.setRoom_id(rooms.get().getRoom_id());
    newroom.setName(rooms.get().getName());
    newroom.setDescription(rooms.get().getDescription());
    newroom.setType_room_id(rooms.get().getType_room_id());
    newroom.setState_room_id(reservedState);

    updateRoomService.updateRoom(newroom);

    // Here trace
    Traceability trace = new Traceability();
    trace.setEventname("Usuario ha reservado");
    trace.setUsername("Juan Gomez");
    trace.setDatenow(LocalDateTime.now());

    // Selecciona la estrategia adecuada según las necesidades del negocio
    gotraceabilityService.setTraceabilityStrategy(saveToDatabaseStrategy);
    // O usa la siguiente línea en lugar de la anterior para cambiar a

    // PrintPdfStrategy
    // gotraceabilityService.setTraceabilityStrategy(printPdfStrategy);

    gotraceabilityService.saveAuditory(trace);

    ResponseFormat Response = new ResponseFormat(
        "El user " + user.get().getName() + "  ha reservado la habitación  "
            + rooms.get().getName(),
        HttpStatus.IM_USED.value(),
        LocalDateTime.now());

    return Response;
  }

}
