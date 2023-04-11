package com.conexionmysql.mysqljdb.aplication.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.conexionmysql.mysqljdb.domain.models.RoomState;
import com.conexionmysql.mysqljdb.domain.services.RoomStateRepository;

@RestController
@Validated
@RequestMapping("/api/roomstate")
public class RoomStateController {

  @Autowired
  private RoomStateRepository roomRepository;

  @GetMapping
  public List<RoomState> getAll() {
    return roomRepository.findAll();
  }

  @PostMapping
  public RoomState create(@RequestBody RoomState newRoom) {
    return roomRepository.save(newRoom);
  }

  @PutMapping("/{id}")
  public ResponseEntity<RoomState> updateUsuario(@PathVariable Long id, @RequestBody RoomState roomstate) {
    Optional<RoomState> findroom = roomRepository.findById(id);
    if (findroom.isPresent()) {
      roomstate.setRooms_state_id(id);
      try {
        RoomState savedRoom = roomRepository.save(roomstate);
        return new ResponseEntity<>(savedRoom, HttpStatus.OK);
      } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
      }
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable Long id) {
    Optional<RoomState> findroom = roomRepository.findById(id);
    Map<String, String> responseHash = new HashMap<>();
    if (findroom.isPresent()) {
      roomRepository.deleteById(id);
      responseHash.put("success", "RoomState Deleted Successfully");

      return ResponseEntity.ok().body(responseHash);
    } else {
      responseHash.put("error", "RoomState No found");
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseHash);

    }
  }

}
