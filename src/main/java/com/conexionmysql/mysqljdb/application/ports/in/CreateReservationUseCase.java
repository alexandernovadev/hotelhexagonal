package com.conexionmysql.mysqljdb.application.ports.in;

import com.conexionmysql.mysqljdb.application.dto.ReservationCreateDto;

public interface CreateReservationUseCase {
  void createReservation(ReservationCreateDto reservationCreateDto);
}
