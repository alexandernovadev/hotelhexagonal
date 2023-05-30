package com.hotels.mart.infrastructure.controllers.room;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

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

import com.hotels.mart.application.dto.ResponseApi;
import com.hotels.mart.application.dto.RoomSaveDto;
import com.hotels.mart.application.services.room.GetAllRoomsService;
import com.hotels.mart.application.services.room.GetRoomByIdService;
import com.hotels.mart.application.services.room.Room;
import com.hotels.mart.application.services.room.SaveRoomService;
import com.hotels.mart.application.services.room.SearchAdvancedService;
import com.hotels.mart.application.services.room.SetAllRoomAvailable;

import lombok.extern.slf4j.Slf4j;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController
@RequestMapping("/api/rooms")
@Slf4j
public class RoomController {

  @Autowired
  private GetRoomByIdService roomService;

  @Autowired
  private GetAllRoomsService getAllRoomsService;

  @Autowired
  private SetAllRoomAvailable setAllRoomAvailable;

  @Autowired
  private SaveRoomService room_service;

  @Autowired
  private SearchAdvancedService search;

  @Operation(summary = "Save Room", description = "Creates a new room. The user must be an admin. The room must have a valid structure with valid type_room_id and state_room_id. The cost of the room must be between 90 and 10,000. ", responses = {
      @ApiResponse(responseCode = "201", description = "Room created successfully", content = @Content(schema = @Schema(implementation = Room.class))),
      @ApiResponse(responseCode = "400", description = "Invalid JSON structure"),
      @ApiResponse(responseCode = "400", description = "Invalid cost range - The cost of the room must be between 90 and 10,000"),
      @ApiResponse(responseCode = "401", description = "Unauthorized access - The user is not admin"),
      @ApiResponse(responseCode = "404", description = "Type or state of room not found - The type_room_id or state_room_id does not exist")
  })
  @PostMapping()
  public ResponseEntity<?> saveRoom(@RequestBody RoomSaveDto roomdto) {
    log.info("Save Rooms");
    var response = room_service.saveRoom(roomdto);

    return new ResponseEntity<>(response, response.getStatus());
  }

  @Operation(summary = "Get Room by ID", description = "Returns a room by its ID", responses = {
      @ApiResponse(responseCode = "202", description = "Room found", content = @Content(schema = @Schema(implementation = ResponseApi.class))),
      @ApiResponse(responseCode = "400", description = "Room ID is required"),
      @ApiResponse(responseCode = "404", description = "Room does not exist")
  })
  @GetMapping("/searchbyid")
  public ResponseEntity<?> serchById(
      @RequestParam(value = "room_id", required = false) Long roomId) {
    log.info("Buscando Room By Id");

    var response = roomService.getRoomByIdValidation(roomId);

    return new ResponseEntity<>(response, response.getStatus());
  }

  @Operation(summary = "Get All Rooms", description = "Returns all rooms", responses = {
      @ApiResponse(responseCode = "200", description = "Success", content = @Content(schema = @Schema(implementation = List.class)))
  })
  @GetMapping
  public ResponseEntity<?> getAllRooms() {
    log.info("Getting all rooms");
    return new ResponseEntity<>(getAllRoomsService.getAllRooms(), HttpStatus.OK);
  }

  @Operation(summary = "Search Rooms", description = "Searches rooms based on provided query parameters", responses = {
      @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = ResponseApi.class))),
      @ApiResponse(responseCode = "400", description = "Invalid parameters provided"),
      @ApiResponse(responseCode = "404", description = "Room, Room Type, or Room State does not exist")
  })
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

  @Operation(summary = "Set all rooms as available", description = "Sets the state of all rooms to available", responses = {
      @ApiResponse(responseCode = "200", description = "Success - All rooms have been set to available")
  })
  @PutMapping("/setAllRoomAvailable")
  public ResponseEntity<?> setAllRoomAvailable() {
    log.info("Setting all rooms available");
    setAllRoomAvailable.setAllRoomAvailable();

    var res = new ResponseApi("Rooms Updated to Avaliable",
        HttpStatus.OK,
        LocalDateTime.now());

    return new ResponseEntity<>(res, HttpStatus.OK);
  }

}
