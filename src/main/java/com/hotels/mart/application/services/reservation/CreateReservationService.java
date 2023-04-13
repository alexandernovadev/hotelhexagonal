package com.hotels.mart.application.services.reservation;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.mart.domain.entities.Reservation;
import com.hotels.mart.infrastructure.jpa.repositories.ReservationRepository;

@Service
public class CreateReservationService {

  @Autowired
  private ReservationRepository reservationRepository;

  public void createReservation(@Valid Reservation reservationCreateDto) {
    reservationRepository.save(reservationCreateDto);
  }

}
