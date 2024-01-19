package com.hotels.mart.domain.entities;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Sex")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Sex {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "sex_id")
  private Integer sex_id;

  @Column(name = "name", length = 50)
  private String name;

  @Column(name = "state", length = 50)
  private String state;

  @Column(name = "status", length = 50)
  private String status;

  @Column(name = "created_at")
  private LocalDateTime created_at;
}
