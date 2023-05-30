package com.hotels.mart.application.services.auth;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hotels.mart.application.dto.ResponseApi;
import com.hotels.mart.application.dto.UserRegisterDto;
import com.hotels.mart.domain.entities.User;
import com.hotels.mart.domain.entities.UserState;
import com.hotels.mart.infrastructure.jpa.repositories.UserRepository;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

@Service
public class RegisterUserService {
  @Autowired
  private UserRepository userRepository;

  public ResponseApi createUser(UserRegisterDto userdto) {

    // Validating that it's a valid email
    String email = userdto.getEmail();
    String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$"; // Mauby in utils goes it ??
    Pattern pattern = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);

    Matcher matcher = pattern.matcher(email);

    if (!matcher.matches()) {
      return new ResponseApi(
          "Invalid email format",
          HttpStatus.BAD_REQUEST,
          LocalDateTime.now());
    }

    // Validar que sea un nombre con at least 4 carateres y meno de 80
    String name = userdto.getName();
    if (name.length() < 4 || name.length() > 80) {
      return new ResponseApi(
          "Invalid name length. Name must be between 4 and 80 characters",
          HttpStatus.BAD_REQUEST,
          LocalDateTime.now());
    }

    // Validar que la contraseña tenga al menos 5 caracteres y menos de 20
    String password = userdto.getPassword();
    if (password.length() < 5 || password.length() > 20) {
      return new ResponseApi(
          "Invalid password length. Password must be between 5 and 20 characters",
          HttpStatus.BAD_REQUEST,
          LocalDateTime.now());
    }

    // Encriptar
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    String encodedPassword = passwordEncoder.encode(userdto.getPassword());

    // Set State 1 (active by default)
    UserState userstate = new UserState();
    userstate.setUser_state_id(1L);
    userstate.setState("Active");

    User user = new User();
    user.setName(userdto.getName());
    user.setPassword(encodedPassword);
    user.setEmail(userdto.getEmail());
    user.setUser_state_id(userstate);
    user.setUser_type("guest");
    userRepository.save(user);

    return new ResponseApi(
        "User created successfully",
        HttpStatus.CREATED,
        LocalDateTime.now(),
        List.of(user));
  }

}
