package com.hotels.mart.application.services.userstate;
import org.springframework.stereotype.Service;

import com.hotels.mart.domain.entities.UserState;
import com.hotels.mart.infrastructure.jpa.repositories.UserStateRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
@Service
public class GetUserStateByIdService {
  @Autowired
  private UserStateRepository userstateRepository;

  public Optional<UserState> getUserStateById(Long id) {
    return userstateRepository.findById(id);
  }
  
}







