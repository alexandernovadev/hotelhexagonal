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
import org.springframework.web.servlet.ModelAndView;

import com.conexionmysql.mysqljdb.aplication.services.UsuarioRepository;
import com.conexionmysql.mysqljdb.domain.models.Usuario;

@RestController
@Validated 
public class UsuarioController {

  @Autowired
  private UsuarioRepository usuarioRepository;


  @GetMapping("/otromas")
  public ModelAndView getget() {
      List<Usuario> userList = new ArrayList<>();
      Usuario p = new Usuario();
      p.setName("John");
      Usuario p1 = new Usuario();
      p.setName("Misdo");
      userList.add(p1);
    
      
      ModelAndView modelAndView = new ModelAndView("user-list");
      modelAndView.addObject("users", userList);
      
      return modelAndView;
  }

  
  @GetMapping("/usuario")
  public List<Usuario> obtenerAll() {
    return usuarioRepository.findAll();
  }

  @PostMapping("/usuario")
  public Usuario agregarUsuario(@RequestBody Usuario nuevoUsuario) {
    
    
    return usuarioRepository.save(nuevoUsuario);
    // return usuarioRepository.findAll().get(0);
  }

  @PutMapping("usuario/{id}")
  public ResponseEntity<Usuario> updateUsuario(@PathVariable Long id, @RequestBody @Valid Usuario usuario) {
    Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
    if (usuarioOptional.isPresent()) {
      usuario.setId(id);
      try {
        Usuario savedUsuario = usuarioRepository.save(usuario);
        return new ResponseEntity<>(savedUsuario, HttpStatus.OK);
      } catch (Exception e) {
        // TODO: handle exception
        return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
      }
    
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping("/perrocaliente")
  public ResponseEntity<Object> crearUsuario(@RequestBody @Valid Usuario usuario, BindingResult bindingResult) {
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

  @DeleteMapping("/usuario/{id}")
  public ResponseEntity<?> deleteUsuario(@PathVariable Long id) {
    Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
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

}
