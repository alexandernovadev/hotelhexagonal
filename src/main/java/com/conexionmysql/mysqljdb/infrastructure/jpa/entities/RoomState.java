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
@Table(name = "rooms_state")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RoomState {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long rooms_state_id; 
  private String state;
}