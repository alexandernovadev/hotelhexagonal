package com.conexionmysql.mysqljdb.infrastructure.jpa.entities;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
import jakarta.persistence.OneToOne;
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
  private Long reservation_id;

  @OneToOne
  @JoinColumn(name = "user_id")
  private User user_id;

  @OneToOne
  @JoinColumn(name = "room_id")
  private Room room_id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "reservation_state_id")
  @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
  private ReservationState reservation_state_id;

  @NotNull(message = "Check-in date is required")
  @Column(name = "check_in_date")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime check_in_date;

  @NotNull(message = "Check-out date is required")
  @Column(name = "check_out_date")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime check_out_date;

}
