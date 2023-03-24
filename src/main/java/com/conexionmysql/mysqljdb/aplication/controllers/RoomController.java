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

import com.conexionmysql.mysqljdb.aplication.services.RoomRepository;
import com.conexionmysql.mysqljdb.domain.models.Room;

@RestController
@Validated
@RequestMapping("/api/room")
public class RoomController {

  @Autowired
  private RoomRepository roomRepository;

  @GetMapping
  public List<Room> getAll() {
    return roomRepository.findAll();
  }

  @PostMapping
  public Room create(@RequestBody Room newRoom) {
    return roomRepository.save(newRoom);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Room> updateUsuario(@PathVariable Long id, @RequestBody Room room) {
    Optional<Room> finduser = roomRepository.findById(id);
    if (finduser.isPresent()) {
      room.setRoom_id(id);
      try {
        Room savedRoom = roomRepository.save(room);
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
    Optional<Room> findroom = roomRepository.findById(id);
    Map<String, String> responseHash = new HashMap<>();
    if (findroom.isPresent()) {
      roomRepository.deleteById(id);
      responseHash.put("success", "Room Deleted Successfully");

      return ResponseEntity.ok().body(responseHash);
    } else {
      responseHash.put("error", "Room No found");
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseHash);

    }
  }

}
