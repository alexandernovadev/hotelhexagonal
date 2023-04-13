package com.conexionmysql.mysqljdb.infrastructure.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.conexionmysql.mysqljdb.application.services.user.CreateUserService;
import com.conexionmysql.mysqljdb.application.services.user.GetAllUserService;
import com.conexionmysql.mysqljdb.application.services.user.UpdateUserService;
import com.conexionmysql.mysqljdb.infrastructure.jpa.entities.User;

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
   

   @GetMapping
   public ResponseEntity<?> getUsers() {
      log.info("Getting users");
      return new ResponseEntity<>(getAllUserService.getAllUsers(), HttpStatus.OK);
   }

   @PostMapping
   public ResponseEntity<?> createUser(@RequestBody User userDto) {
      log.info("Creating user: {}", userDto);
      createUserService.createUser(userDto);
      return new ResponseEntity<>(HttpStatus.CREATED);
   }

   @PutMapping
   public ResponseEntity<?> updateUser(@RequestBody User userDto) {
      log.info("Updating user: {}", userDto);
      updateUserService.updateUser(userDto);
      return new ResponseEntity<>(HttpStatus.CREATED);
   }

   @DeleteMapping
   public ResponseEntity<?> deleteUser(@RequestBody User userDto) {
      log.info("Deleting user: {}", userDto);
      createUserService.createUser(userDto);
      return new ResponseEntity<>(HttpStatus.CREATED);
   }
}
