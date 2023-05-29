package com.hotels.mart.application.services.room;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hotels.mart.application.dto.ResponseApi;
import com.hotels.mart.domain.entities.RoomState;
import com.hotels.mart.domain.entities.Room;
import com.hotels.mart.domain.entities.RoomType;
import com.hotels.mart.infrastructure.jpa.repositories.RoomRepository;
import com.hotels.mart.infrastructure.jpa.repositories.RoomStateRepository;
import com.hotels.mart.infrastructure.jpa.repositories.RoomTypeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SearchAdvancedService {

  @Autowired
  private RoomStateRepository roomStateRepository;

  @Autowired
  private RoomTypeRepository roomTypeRepository;

  @Autowired
  private RoomRepository roomRepository;

  // @Autowired
  // private UserRepository userRepository;

  public ResponseApi roomByQueryParameters(
      Long roomId,
      Long typeRoomId,
      Long stateRoomId,
      BigDecimal cost,
      String name,
      String description) {

    // Validate room_id
    if (roomId != null) {
      Optional<Room> room = roomRepository.findById(roomId);
      if (!room.isPresent()) {
        return new ResponseApi("Room id does not exist",
            HttpStatus.NOT_FOUND, LocalDateTime.now());
      }
    }

    // Validate type_room_id
    if (typeRoomId != null) {
      Optional<RoomType> roomType = roomTypeRepository.findById(typeRoomId);
      if (!roomType.isPresent()) {
        return new ResponseApi("Type room id does not exist",
            HttpStatus.NOT_FOUND, LocalDateTime.now());
      }
    }

    // Validate state_room_id
    if (stateRoomId != null) {
      Optional<RoomState> roomState = roomStateRepository.findById(stateRoomId);
      if (!roomState.isPresent()) {
        return new ResponseApi("State room id does not exist",
            HttpStatus.NOT_FOUND, LocalDateTime.now());
      }
    }

    // Validate cost
    if (cost != null) {
      if (cost.compareTo(BigDecimal.valueOf(90)) < 0
          || cost.compareTo(BigDecimal.valueOf(10000)) > 0) {
        return new ResponseApi("Cost must be between 90 and 10000",
            HttpStatus.BAD_REQUEST, LocalDateTime.now());
      }
    }

    // If all validations are passed, then search for rooms
    List<Room> rooms = roomRepository.findByCriteria(roomId,
        typeRoomId, stateRoomId, name, description, cost);

    // You might want to transform the List<Room>
    // to a format suitable for your API response
    return new ResponseApi("Room List succesfully",
        HttpStatus.CREATED,
        LocalDateTime.now(),
        rooms);

  }
}
