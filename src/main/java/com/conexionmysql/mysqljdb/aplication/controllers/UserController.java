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

import com.conexionmysql.mysqljdb.domain.models.User;
import com.conexionmysql.mysqljdb.domain.services.UserRepository;

@RestController
@Validated
@RequestMapping("/api/users")
public class UserController {

  @Autowired
  private UserRepository userRepository;

  @GetMapping  
  public List<User> getAll() {
    return userRepository.findAll();
  }

  @PostMapping
  public User create(@RequestBody User newUser) {
    return userRepository.save(newUser);
  }

  @PutMapping("/{id}")
  public ResponseEntity<User> update(@PathVariable Long id, @RequestBody @Valid User usuario) {
    Optional<User> finduser = userRepository.findById(id);
    if (finduser.isPresent()) {
      usuario.setUser_id(id);
      try {
        User savedUser = userRepository.save(usuario);
        return new ResponseEntity<>(savedUser, HttpStatus.OK);
      } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
      }

    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable Long id) {
    Optional<User> findUser = userRepository.findById(id);
    Map<String, String> responseHash = new HashMap<>();
    if (findUser.isPresent()) {
      userRepository.deleteById(id);

      responseHash.put("success", "User Deleted Successfully");

      return ResponseEntity.ok().body(responseHash);
    } else {
      responseHash.put("error", "User No found");
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseHash);

    }
  }
}
