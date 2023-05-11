package com.hotels.mart.application.services.room;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.mart.domain.entities.Room;
import com.hotels.mart.infrastructure.jpa.repositories.RoomRepository;

@Service
public class GetAllRoomsService {

  @Autowired
  private RoomRepository roomRepository;

  public List<Room> getAllRooms() {
    return roomRepository.findAll();
  }
}
