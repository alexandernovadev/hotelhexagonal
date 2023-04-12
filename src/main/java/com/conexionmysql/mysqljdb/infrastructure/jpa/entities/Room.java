package com.conexionmysql.mysqljdb.infrastructure.jpa.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "rooms")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long room_id;

  @OneToOne
  @JoinColumn(name = "type_room_id")
  private RoomType type_room_id;

  @OneToOne
  @JoinColumn(name = "state_room_id")
  private RoomState state_room_id;

  private String name;
  
  private String description;
}
