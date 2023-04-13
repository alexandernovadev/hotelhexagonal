package com.hotels.mart.application.ports.out;

import com.hotels.mart.domain.entities.User;

public interface SaveUserPort {

  /**
   * Guarda un nuevo usuario en la base de datos.
   *
   * @param user el usuario a guardar
   * @return el usuario guardado con su ID asignado
   */
  User save(User user);

}