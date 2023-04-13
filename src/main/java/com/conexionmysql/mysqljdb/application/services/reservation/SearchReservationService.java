package com.conexionmysql.mysqljdb.application.services.reservation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conexionmysql.mysqljdb.application.dto.ReservationSearchDto;
import com.conexionmysql.mysqljdb.domain.entities.Reservation;
import com.conexionmysql.mysqljdb.infrastructure.jpa.repositories.ReservationRepository;

@Service
public class SearchReservationService {
  @Autowired
  private ReservationRepository reservationRepository;

 
public List<Reservation> searchReservations(ReservationSearchDto reservationCreateDto) {
  return reservationRepository.findByCriteria(
      reservationCreateDto.getUserId(),
      reservationCreateDto.getRoomId(),
      reservationCreateDto.getReservationStateId(),
      reservationCreateDto.getCheckInDate(),
      reservationCreateDto.getCheckOutDate());

}
}
