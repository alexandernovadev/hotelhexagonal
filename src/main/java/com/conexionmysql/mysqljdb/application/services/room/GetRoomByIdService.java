package com.conexionmysql.mysqljdb.application.services.room;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conexionmysql.mysqljdb.domain.entities.Room;
import com.conexionmysql.mysqljdb.infrastructure.jpa.repositories.RoomRepository;

@Service
public class GetRoomByIdService {

  @Autowired
  private RoomRepository roomRepository;

  public Optional<Room> getRoomById(Long id) {
    return roomRepository.findById(id);
  }
}
