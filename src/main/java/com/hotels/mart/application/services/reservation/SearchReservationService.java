package com.hotels.mart.application.services.reservation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.mart.application.dto.ReservationSearchDto;
import com.hotels.mart.domain.entities.Reservation;
import com.hotels.mart.infrastructure.jpa.repositories.ReservationRepository;

@Service
public class SearchReservationService {
  @Autowired
  private ReservationRepository reservationRepository;

  

public List<Reservation> searchReservations(ReservationSearchDto reservationCreateDto) {

  return reservationRepository.findByCriteria(
      reservationCreateDto.getReservationId(),
      reservationCreateDto.getUserId(),
    
      reservationCreateDto.getRoomId(),
      reservationCreateDto.getReservationStateId(),

      reservationCreateDto.getCheckInDate(),

      reservationCreateDto.getCheckOutDate());


}
}
