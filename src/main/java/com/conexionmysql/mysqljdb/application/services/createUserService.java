package com.conexionmysql.mysqljdb.application.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conexionmysql.mysqljdb.infrastructure.jpa.entities.User;
import com.conexionmysql.mysqljdb.infrastructure.jpa.repositories.UserRepository;

@Service
public class CreateUserService {
  @Autowired
  private UserRepository userRepository;

  public void createUser(User user) {
    userRepository.save(user);
  }

}
