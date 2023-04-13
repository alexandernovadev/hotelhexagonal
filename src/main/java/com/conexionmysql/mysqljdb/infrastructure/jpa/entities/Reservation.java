package com.conexionmysql.mysqljdb.infrastructure.jpa.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

import jakarta.persistence.ManyToOne;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reservations")
public class Reservation {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "reservation_id")
  private Long id;

  @Column(name = "user_id")
  private Long userId;

  @Column(name = "room_id")
  private Long roomId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "reservation_state_id")
  private ReservationState state;

  @Column(name = "check_in_date")
  private LocalDate checkInDate;

  @Column(name = "check_out_date")
  private LocalDate checkOutDate;
}


