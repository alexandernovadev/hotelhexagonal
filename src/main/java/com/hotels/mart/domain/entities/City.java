package com.hotels.mart.domain.entities;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "City")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class City {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "city_id")
  private Integer city_id;

  @Column(name = "name", length = 255)
  private String name;

  @Column(name = "state", length = 50)
  private String state;

  @Column(name = "status", length = 50)
  private String status;

  @Column(name = "created_at")
  private LocalDateTime created_at;
}
