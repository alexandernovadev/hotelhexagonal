package com.conexionmysql.mysqljdb.application.ports.out;

import com.conexionmysql.mysqljdb.domain.model.User;

public interface SaveUserPort {

  /**
   * Guarda un nuevo usuario en la base de datos.
   *
   * @param user el usuario a guardar
   * @return el usuario guardado con su ID asignado
   */
  User save(User user);

}