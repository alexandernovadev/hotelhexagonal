package com.hotels.mart.application.services.room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.mart.domain.entities.Room;
import com.hotels.mart.infrastructure.jpa.repositories.RoomRepository;

@Service
public class UpdateRoomService {
  @Autowired
  private RoomRepository roomRepository;

  public void updateRoom(Room room) {
    roomRepository.save(room);
  }

  
}


