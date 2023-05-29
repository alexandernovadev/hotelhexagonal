package com.hotels.mart.infrastructure.controllers.room;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import com.hotels.mart.application.dto.ResponseFormat;
import com.hotels.mart.application.dto.RoomSaveDto;
import com.hotels.mart.application.services.room.GetAllRoomsService;
import com.hotels.mart.application.services.room.GetRoomByIdService;
import com.hotels.mart.application.services.room.SaveRoomService;
import com.hotels.mart.application.services.room.SearchAdvancedService;
import com.hotels.mart.application.services.room.SetAllRoomAvailable;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/rooms")
@Slf4j
@Tag(name = "Rooms")
public class RoomController {

  @Autowired
  private GetRoomByIdService getRoomByIdService;

  @Autowired
  private GetAllRoomsService getAllRoomsService;

  @Autowired
  private SetAllRoomAvailable setAllRoomAvailable;

  @Autowired
  private SaveRoomService room_service;

  @Autowired
  private SearchAdvancedService search;

  @PostMapping()
  public ResponseEntity<?> saveRoom(@RequestBody RoomSaveDto roomdto) {
    log.info("Save Rooms");

    var response = room_service.saveRoom(roomdto);

    return new ResponseEntity<>(response, response.getStatus());
  }

  @GetMapping("/searchById")
  public ResponseEntity<?> serchById(
      @RequestParam(value = "room_id", required = false) Long roomId) {
    log.info("Buscando Room By Id");
    // Si no hay nada en el requestParam, se retorna un badRequest
    if (roomId == null) {
      ResponseFormat responseFormat = new ResponseFormat("El id de la habitacion es requerido",
          HttpStatus.BAD_REQUEST.value(), LocalDateTime.now());

      return ResponseEntity.badRequest().body(responseFormat);
    }
    // Si la respuesta es vacia, se retorna u erro dicindo que no hay datos con ese
    // ID
    var room = getRoomByIdService.getRoomById(roomId);

    if (room.isEmpty()) {
      ResponseFormat responseFormat = new ResponseFormat("No se encontro la habitacion con el id: " + roomId,
          HttpStatus.NOT_FOUND.value(), LocalDateTime.now());
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseFormat);
    }
    // Si todo sale bien, se retorna el objeto
    return ResponseEntity.ok(room);

  }

  @GetMapping
  public ResponseEntity<?> getAllRooms() {
    log.info("Getting all rooms");
    return new ResponseEntity<>(getAllRoomsService.getAllRooms(), HttpStatus.OK);
  }

  @GetMapping("/search")
  public ResponseEntity<?> searchRooms(
      @RequestParam(value = "room_id", required = false) Long room_id,
      @RequestParam(value = "type_room_id", required = false) Long type_room_id,
      @RequestParam(value = "state_room_id", required = false) Long state_room_id,
      @RequestParam(value = "name", required = false) String name,
      @RequestParam(value = "description", required = false) String description,
      @RequestParam(value = "cost", required = false) BigDecimal cost) {
    log.info("Search Rooms");

    var response = search.roomByQueryParameters(room_id, type_room_id, state_room_id, cost, name, description);

    return new ResponseEntity<>(response, response.getStatus());

  }

  @Operation(description = "Put endpoint for manager", 
  summary = "This is a summary for management get endpoint", responses = {
      @ApiResponse(description = "Success", responseCode = "200"),
      @ApiResponse(description = "Unauthorized / Invalid Token", responseCode = "403") })
  @PutMapping("/setAllRoomAvailable")
  public ResponseEntity<?> setAllRoomAvailable() {
    log.info("Setting all rooms available");
    setAllRoomAvailable.setAllRoomAvailable();
    return new ResponseEntity<>(HttpStatus.OK);
  }

}
