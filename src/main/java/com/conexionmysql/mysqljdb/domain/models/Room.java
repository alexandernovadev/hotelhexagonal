package com.conexionmysql.mysqljdb.domain.models;

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
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Room {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long room_id;
  private String type_room_id;
  private String state;
  private String name;
  private String description;
}
