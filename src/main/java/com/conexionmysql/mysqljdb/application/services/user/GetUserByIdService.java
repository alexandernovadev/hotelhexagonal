package com.conexionmysql.mysqljdb.application.services.user;
import org.springframework.stereotype.Service;

import com.conexionmysql.mysqljdb.domain.entities.User;
import com.conexionmysql.mysqljdb.infrastructure.jpa.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
@Service
public class GetUserByIdService {
  @Autowired
  private UserRepository userRepository;

  public User getUserById(Long id) {
    return userRepository.findById(id).orElse(null);
  }
  
}







