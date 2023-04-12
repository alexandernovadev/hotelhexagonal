package com.conexionmysql.mysqljdb.application.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.conexionmysql.mysqljdb.application.ports.in.CreateUserCommand;
import com.conexionmysql.mysqljdb.application.ports.out.SaveUserPort;
import com.conexionmysql.mysqljdb.domain.model.User;

public class createUserService {
  private SaveUserPort saveUserPort;

  @Autowired
  public void CreateUserService(SaveUserPort saveUserPort) {
      this.saveUserPort = saveUserPort;
  }

  public User createUser(CreateUserCommand command) {
      // Aquí puedes agregar validaciones adicionales y lógica de negocio específica para la creación de usuarios.

      User newUser = new User(
      );

      return saveUserPort.save(newUser);
  }
}
