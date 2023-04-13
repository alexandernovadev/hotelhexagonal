package com.conexionmysql.mysqljdb.infrastructure.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.conexionmysql.mysqljdb.application.services.CreateUserService;
import com.conexionmysql.mysqljdb.infrastructure.jpa.entities.User;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/users")
@Slf4j
public class UserController {

   @Autowired
   private CreateUserService createUserService;

   @PostMapping
   public ResponseEntity<?> createUser(@RequestBody User userDto) {
      log.info("Creating user: {}", userDto);
      createUserService.createUser(userDto);
      return new ResponseEntity<>(HttpStatus.CREATED);
   }


   // HAz el enfpoind aqui 
}
