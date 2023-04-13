package com.conexionmysql.mysqljdb.application.dto;

import java.time.LocalDate;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ReservationSearchDto {
  
  private Long userId;
  private Long roomId;
  private Long reservationStateId;
  private LocalDate checkInDate;
  private LocalDate checkOutDate;
}