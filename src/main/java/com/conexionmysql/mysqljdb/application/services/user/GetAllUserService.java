package com.conexionmysql.mysqljdb.application.services.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conexionmysql.mysqljdb.infrastructure.jpa.entities.User;
import com.conexionmysql.mysqljdb.infrastructure.jpa.repositories.UserRepository;

@Service
public class GetAllUserService {
  @Autowired
  private UserRepository userRepository;

  public  List<User> getAllUsers() {
    return userRepository.findAll();
  }
}
