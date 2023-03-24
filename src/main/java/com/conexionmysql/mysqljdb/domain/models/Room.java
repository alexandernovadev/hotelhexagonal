package com.conexionmysql.mysqljdb.domain.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "rooms")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
