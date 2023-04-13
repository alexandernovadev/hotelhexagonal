package com.conexionmysql.mysqljdb.application.services.reservation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conexionmysql.mysqljdb.application.dto.ReservationCreateDto;
import com.conexionmysql.mysqljdb.infrastructure.jpa.entities.Reservation;
import com.conexionmysql.mysqljdb.infrastructure.jpa.repositories.ReservationRepository;

@Service
public class SearchReservationService {
  @Autowired
  private ReservationRepository reservationRepository;

 
public List<Reservation> searchReservations(ReservationCreateDto reservationCreateDto) {
  return reservationRepository.findByCriteria(
      reservationCreateDto.getUser_id(),
      reservationCreateDto.getRoom_id(),
      reservationCreateDto.getReservation_state_id(),
      reservationCreateDto.getCheck_in_date(),
      reservationCreateDto.getCheck_out_date());

}
}
