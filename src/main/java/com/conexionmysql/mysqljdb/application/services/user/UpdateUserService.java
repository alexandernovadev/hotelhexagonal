package com.conexionmysql.mysqljdb.application.services.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conexionmysql.mysqljdb.domain.entities.User;
import com.conexionmysql.mysqljdb.infrastructure.jpa.repositories.UserRepository;

@Service
public class UpdateUserService {
  
  @Autowired
  private UserRepository userRepository;

  public void updateUser(User user) {
    userRepository.save(user);
  }
}