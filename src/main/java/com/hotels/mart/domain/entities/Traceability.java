package com.hotels.mart.domain.entities;

import java.sql.Date;

import jakarta.persistence.Column;
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
@Table(name = "traceability")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Traceability {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)

  @Column(name = "user")
  private String user;

  @Column(name = "eventname")
  private String eventName;

  @Column(name = "dateNow")
  private Date dateNow;
}
