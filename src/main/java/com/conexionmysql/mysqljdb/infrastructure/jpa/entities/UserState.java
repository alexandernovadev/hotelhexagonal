package com.conexionmysql.mysqljdb.infrastructure.jpa.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "users_state")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserState {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long user_state_id; 
  private String state;
}
