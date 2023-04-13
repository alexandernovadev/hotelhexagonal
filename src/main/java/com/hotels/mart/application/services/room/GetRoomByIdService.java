package com.hotels.mart.application.services.room;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.mart.domain.entities.Room;
import com.hotels.mart.infrastructure.jpa.repositories.RoomRepository;

@Service
public class GetRoomByIdService {

  @Autowired
  private RoomRepository roomRepository;

  public Optional<Room> getRoomById(Long id) {
    return roomRepository.findById(id);
  }
}
