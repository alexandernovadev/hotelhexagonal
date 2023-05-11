package com.hotels.mart.application.services.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.mart.infrastructure.jpa.repositories.UserRepository;

@Service
public class DeleteUserService {
  @Autowired
  private UserRepository userRepository;

  public void deleteUser(Long id) {
    userRepository.deleteById(id);
  }
}
