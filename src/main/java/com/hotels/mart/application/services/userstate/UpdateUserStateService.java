package com.hotels.mart.application.services.userstate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.mart.domain.entities.UserState;
import com.hotels.mart.infrastructure.jpa.repositories.UserStateRepository;

@Service
public class UpdateUserStateService {
  
  @Autowired
  private UserStateRepository uexRepository;

  public void updateUserState(UserState uex) {
    uexRepository.save(uex);
  }
}