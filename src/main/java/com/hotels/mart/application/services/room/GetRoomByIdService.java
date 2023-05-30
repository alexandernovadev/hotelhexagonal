package com.hotels.mart.application.services.room;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hotels.mart.application.dto.ResponseApi;
import com.hotels.mart.domain.entities.Room;
import com.hotels.mart.infrastructure.jpa.repositories.RoomRepository;

@Service
public class GetRoomByIdService {

  @Autowired
  private RoomRepository roomRepository;

  public Optional<Room> getRoomById(Long id) {
    return roomRepository.findById(id);
  }

  public ResponseApi getRoomByIdValidation(Long roomId) {

    // If is null roomId
    if (roomId == null) {
      return new ResponseApi(
          "El id de la habitacion es requerido",
          HttpStatus.BAD_REQUEST,
          LocalDateTime.now());
    }

    // Search
    var room = roomRepository.findById(roomId);

    if (room.isEmpty()) {
      return new ResponseApi(
          "The room no exist",
          HttpStatus.NOT_FOUND,
          LocalDateTime.now());
    }

    // Exist and resturn Room
    return new ResponseApi(
        "Get All Rooms",
        HttpStatus.ACCEPTED,
        LocalDateTime.now(),
        List.of(room));
  }
}
