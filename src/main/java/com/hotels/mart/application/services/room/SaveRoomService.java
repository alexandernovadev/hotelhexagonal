package com.hotels.mart.application.services.room;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hotels.mart.application.dto.ResponseApi;
import com.hotels.mart.application.dto.RoomSaveDto;
import com.hotels.mart.domain.entities.Room;
import com.hotels.mart.domain.entities.User;
import com.hotels.mart.infrastructure.jpa.repositories.RoomRepository;
import com.hotels.mart.infrastructure.jpa.repositories.RoomStateRepository;
import com.hotels.mart.infrastructure.jpa.repositories.RoomTypeRepository;
import com.hotels.mart.infrastructure.jpa.repositories.UserRepository;

@Service
public class SaveRoomService {

  @Autowired
  private RoomStateRepository roomStateRepository;

  @Autowired
  private RoomTypeRepository roomTypeRepository;

  @Autowired
  private RoomRepository roomRepository;

  @Autowired
  private UserRepository userRepository;

  public ResponseApi saveRoom(RoomSaveDto roomdto) {

    Room room = roomdto.getRoom();
    Optional<User> userOptional = userRepository.findById(roomdto.getUser_id());

    if (!userOptional.isPresent()) {
      return new ResponseApi(
          "This User No exist !",
          HttpStatus.BAD_REQUEST,
          LocalDateTime.now());
    }
    User user = userOptional.get();

    var userType = user.getUser_type();
    // If user no exist, o si no es admin salga
    if (userType == null || !userType.equals("admin")) {
      return new ResponseApi(
          "Unauthorized access",
          HttpStatus.UNAUTHORIZED,
          LocalDateTime.now());
    }

    // Validate that JSON , cumpla la estructura si no return 302
    if (room == null || room.getName() == null || room.getDescription() == null
        || room.getType_room_id() == null || room.getState_room_id() == null || room.getCost() == null) {

      return new ResponseApi(
          "La estructura del JSON no es válida",
          HttpStatus.BAD_REQUEST,
          LocalDateTime.now());
    }

    // Validate que el typeRoom existe si no retorno 404, no existe ...
    if (!roomTypeRepository.findById(room.getType_room_id().getRooms_type_id()).isPresent()) {
      return new ResponseApi(
          "El tipo de habitación no existe",
          HttpStatus.NOT_FOUND,
          LocalDateTime.now());
    }

    // Validate que el stateRoom existe si no retornar 404, no existe ...
    if (!roomStateRepository.findById(room.getState_room_id().getRooms_state_id()).isPresent()) {
      return new ResponseApi(
          "El estado de habitación no existe",
          HttpStatus.NOT_FOUND,
          LocalDateTime.now());
    }

    // validate que es costo sea mayor a 90 y menor que 10.000 si no retornar 403
    // error
    if (room.getCost().compareTo(new BigDecimal("90")) < 0
        || room.getCost().compareTo(new BigDecimal("10000")) > 0) {
      return new ResponseApi(
          "El costo de la habitación debe estar entre 90 y 10.000",
          HttpStatus.BAD_REQUEST,
          LocalDateTime.now());
    }

    // All riight with data
    ResponseApi ResponseApi = new ResponseApi(
        "Room created succesfully",
        HttpStatus.CREATED,
        LocalDateTime.now(),
        room);

    roomRepository.save(room);

    return ResponseApi;

  }

}
