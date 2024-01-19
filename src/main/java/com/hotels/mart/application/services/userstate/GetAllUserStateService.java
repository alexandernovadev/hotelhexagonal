package com.hotels.mart.application.services.userstate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.mart.domain.entities.UserState;
import com.hotels.mart.infrastructure.jpa.repositories.UserStateRepository;

@Service
public class GetAllUserStateService {
  @Autowired
  private UserStateRepository userstateRepository;

  public  List<UserState> getAllUserStates() {
    return userstateRepository.findAll();
  }
}
