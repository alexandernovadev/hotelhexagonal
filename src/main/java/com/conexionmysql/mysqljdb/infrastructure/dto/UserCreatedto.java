package com.conexionmysql.mysqljdb.infrastructure.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCreatedto {
  private String userType;
  private Long userStateId;
  private String name;
  private String email;
  private String password;
}



