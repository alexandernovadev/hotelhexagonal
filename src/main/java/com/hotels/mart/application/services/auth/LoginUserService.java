package com.hotels.mart.application.services.auth;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hotels.mart.application.dto.LoginUserDto;
import com.hotels.mart.application.dto.ResponseApi;
import com.hotels.mart.domain.entities.User;
import com.hotels.mart.infrastructure.config.JwtUtil;
import com.hotels.mart.infrastructure.jpa.repositories.UserRepository;

@Service
public class LoginUserService {
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private BCryptPasswordEncoder passwordEncoder;

  public ResponseApi doLogin(LoginUserDto loginUserDto) {
    String email = loginUserDto.getEmail();
    String password = loginUserDto.getPassword();

    // Validate that fields not empty
    if (email.isEmpty() || password.isEmpty()) {
      return new ResponseApi(
          "Should send data",
          HttpStatus.I_AM_A_TEAPOT,
          LocalDateTime.now());
    }

    // Validate that user exists in the database
    User user = userRepository.findByEmail(email);
    if (user == null) {
      return new ResponseApi(
          "User does not exist",
          HttpStatus.NOT_FOUND,
          LocalDateTime.now());
    }

    // Validate that the password is correct
    String storedPassword = user.getPassword();
    if (!passwordEncoder.matches(password, storedPassword)) {
      return new ResponseApi(
          "Invalid password",
          HttpStatus.UNAUTHORIZED,
          LocalDateTime.now());
    }

    // If all validations pass, generate the JWT token
    JwtUtil jwtUtil = new JwtUtil();
    String token = jwtUtil.generateToken(email);

    return new ResponseApi(
        "User logged in successfully",
        HttpStatus.CREATED,
        LocalDateTime.now(),
        token);
  }
}
