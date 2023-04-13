package com.hotels.mart.application.services.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.mart.domain.entities.User;
import com.hotels.mart.infrastructure.jpa.repositories.UserRepository;

@Service
public class UpdateUserService {
  
  @Autowired
  private UserRepository userRepository;

  public void updateUser(User user) {
    userRepository.save(user);
  }
}