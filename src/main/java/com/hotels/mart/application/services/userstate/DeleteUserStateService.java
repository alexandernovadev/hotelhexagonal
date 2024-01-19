package com.hotels.mart.application.services.userstate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.mart.infrastructure.jpa.repositories.UserStateRepository;

@Service
public class DeleteUserStateService {
  @Autowired
  private UserStateRepository userstateRepository;

  public void deleteUserState(Long id) {
    userstateRepository.deleteById(id);
  }
}
