package com.conexionmysql.mysqljdb.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

  private Long user_id;
  private String user_type;
  private String user_state;
  private String name;
  private String email;
  private String password;


   /**
     * Calcula la cantidad de días entre la fecha de registro (check-in) y la fecha de salida (check-out).
     *
     * @return la cantidad de días de la reserva
    public long getUserActives() {
      return ChronoUnit.DAYS.between(checkInDate, checkOutDate);
  }
     */

}


