package com.hotels.mart.application.ports.in;

import com.hotels.mart.application.dto.ReservationCreateDto;
// ordenado
public interface CreateReservationUseCase {
  void createReservation(ReservationCreateDto reservationCreateDto);
}
