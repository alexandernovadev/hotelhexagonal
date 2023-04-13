package com.hotels.mart.application.dto;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ReservationSearchDto {
  
  private Long reservationId;
  private Long userId;
  private Long roomId;
  private Long reservationStateId;
  private LocalDateTime checkInDate;
  private LocalDateTime checkOutDate;
}