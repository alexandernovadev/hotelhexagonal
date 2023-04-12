package com.conexionmysql.mysqljdb.application.ports.in;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CreateUserCommand {
  private String name;
  private Long userStateId;
  private String email;
  private String password;
}
