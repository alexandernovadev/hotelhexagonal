package com.hotels.mart.application.services.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.mart.domain.entities.User;
import com.hotels.mart.infrastructure.jpa.repositories.UserRepository;

@Service
public class GetAllUserService {
  @Autowired
  private UserRepository userRepository;

  public  List<User> getAllUsers() {
    return userRepository.findAll();
  }
}
