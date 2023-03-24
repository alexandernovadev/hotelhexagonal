package com.conexionmysql.mysqljdb.aplication.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.conexionmysql.mysqljdb.aplication.services.UserStateRepository;
import com.conexionmysql.mysqljdb.domain.models.UserState;

@RestController
@Validated
@RequestMapping("/api/userstate")
public class UserStateController {

  @Autowired
  private UserStateRepository userStateRepository;

  @GetMapping
  public List<UserState> getAll() {
    return userStateRepository.findAll();
  }
 

}
