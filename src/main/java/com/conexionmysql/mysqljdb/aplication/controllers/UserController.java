package com.conexionmysql.mysqljdb.aplication.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.conexionmysql.mysqljdb.aplication.services.UserRepository;
import com.conexionmysql.mysqljdb.domain.models.User;

@RestController
@Validated
public class UserController {

  @Autowired
  private UserRepository usuarioRepository;

  @GetMapping("/users")
  public List<User> obtenerAll() {
    return usuarioRepository.findAll();
  }

  @PostMapping("/user")
  public User agregarUsuario(@RequestBody User nuevoUsuario) {
    return usuarioRepository.save(nuevoUsuario);
  }

  @PutMapping("user/{id}")
  public ResponseEntity<User> updateUsuario(@PathVariable Long id, @RequestBody @Valid User usuario) {
    Optional<User> usuarioOptional = usuarioRepository.findById(id);
    if (usuarioOptional.isPresent()) {
      usuario.setUser_id(id);
      try {
        User savedUsuario = usuarioRepository.save(usuario);
        return new ResponseEntity<>(savedUsuario, HttpStatus.OK);
      } catch (Exception e) {
        // TODO: handle exception
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
      }

    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/usuario/{id}")
  public ResponseEntity<?> deleteUsuario(@PathVariable Long id) {
    Optional<User> usuarioOptional = usuarioRepository.findById(id);
    Map<String, String> responseHash = new HashMap<>();
    if (usuarioOptional.isPresent()) {
      usuarioRepository.deleteById(id);

      responseHash.put("success", "User Deleted Successfully");

      return ResponseEntity.ok().body(responseHash);
    } else {
      responseHash.put("error", "User No found");
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseHash);

    }
  }

  @PostMapping("/perrocaliente")
  public ResponseEntity<Object> crearUsuario(@RequestBody @Valid User usuario, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      Map<String, String> errors = new HashMap<>();
      for (FieldError error : bindingResult.getFieldErrors()) {
        errors.put(error.getField(), error.getDefaultMessage());
      }
      return ResponseEntity.badRequest().body(errors);
    }
    usuarioRepository.save(usuario);
    return ResponseEntity.ok(usuario);
  }

}
