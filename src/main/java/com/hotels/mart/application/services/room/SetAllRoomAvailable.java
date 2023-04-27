package com.hotels.mart.application.services.room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.mart.infrastructure.jpa.repositories.RoomRepository;

import jakarta.transaction.Transactional;

@Service
public class SetAllRoomAvailable {
  
  @Autowired
  private RoomRepository roomRepository;

  @Transactional
  public void setAllRoomAvailable() {
    roomRepository.setAllRoomStateRoomIdToOne();
  }
}
