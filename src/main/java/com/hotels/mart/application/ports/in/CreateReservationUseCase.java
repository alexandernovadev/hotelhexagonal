package com.hotels.mart.application.ports.in;

import com.hotels.mart.application.dto.ReservationCreateDto;

public interface CreateReservationUseCase {
  void createReservation(ReservationCreateDto reservationCreateDto);
}
