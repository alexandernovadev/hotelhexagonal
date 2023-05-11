package com.hotels.mart.application.services.room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.mart.domain.entities.RoomState;
import com.hotels.mart.infrastructure.jpa.repositories.RoomStateRepository;

@Service
public class SearchRoomStateByIdService {

  @Autowired
  private RoomStateRepository roomStateRepository;

  public RoomState getRoomState(Long id) {
    return roomStateRepository.findById(id).get();
  }

}
