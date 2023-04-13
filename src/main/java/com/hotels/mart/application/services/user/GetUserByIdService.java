package com.hotels.mart.application.services.user;
import org.springframework.stereotype.Service;

import com.hotels.mart.domain.entities.User;
import com.hotels.mart.infrastructure.jpa.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
@Service
public class GetUserByIdService {
  @Autowired
  private UserRepository userRepository;

  public User getUserById(Long id) {
    return userRepository.findById(id).orElse(null);
  }
  
}







