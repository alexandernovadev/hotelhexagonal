package com.hotels.mart.infrastructure.controllers.user;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotels.mart.application.dto.ResponseFormat;
import com.hotels.mart.application.services.user.CreateUserService;
import com.hotels.mart.application.services.user.DeleteUserService;
import com.hotels.mart.application.services.user.GetAllUserService;
import com.hotels.mart.application.services.user.GetUserByIdService;
import com.hotels.mart.application.services.user.UpdateUserService;
import com.hotels.mart.domain.entities.User;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/users")
@Slf4j
public class UserController {

   @Autowired
   private CreateUserService createUserService;
   @Autowired
   private GetAllUserService getAllUserService;
   @Autowired
   private UpdateUserService updateUserService;
   @Autowired
   private DeleteUserService deleteUserService;

   @Autowired
   private GetUserByIdService getUserByIdService;

   @GetMapping("/{id}")
   public ResponseEntity<?> getUserById(@PathVariable Long id) {
      log.info("Getting user with ID: {}", id);
      return new ResponseEntity<>(getUserByIdService.getUserById(id), HttpStatus.OK);
   }

   @GetMapping
   public ResponseEntity<?> getUsers() {
      log.info("Getting users");
      return new ResponseEntity<>(getAllUserService.getAllUsers(), HttpStatus.OK);
   }

   @PostMapping
   public ResponseEntity<?> createUser(@RequestBody User userDto) {
      log.info("Creating user: {}", userDto);

      createUserService.createUser(userDto);

      ResponseFormat response = new ResponseFormat();
      response.setMessage("User created successfully");
      response.setStatus(HttpStatus.CREATED.value());
      response.setTimestamp(LocalDateTime.now());

      return new ResponseEntity<>(response, HttpStatus.CREATED);
   }

   @PutMapping
   public ResponseEntity<?> updateUser(@RequestBody User userDto) {
      log.info("Updating user: {}", userDto);
      updateUserService.updateUser(userDto);

      ResponseFormat response = new ResponseFormat();
      response.setMessage("User Updated successfully");
      response.setStatus(HttpStatus.CREATED.value());
      response.setTimestamp(LocalDateTime.now());

      return new ResponseEntity<>(response, HttpStatus.CREATED);

   }

   @DeleteMapping("/{id}")
   public ResponseEntity<?> deleteUser(@PathVariable Long id) {
      log.info("Deleting user with ID: {}", id);
      deleteUserService.deleteUser(id);

      ResponseFormat response = new ResponseFormat();
      response.setMessage("User Deleted successfully");
      response.setStatus(HttpStatus.CREATED.value());
      response.setTimestamp(LocalDateTime.now());

      return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);

   }

}
