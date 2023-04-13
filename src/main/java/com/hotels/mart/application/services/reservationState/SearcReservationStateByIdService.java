package com.hotels.mart.application.services.reservationState;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.mart.domain.entities.ReservationState;
import com.hotels.mart.infrastructure.jpa.repositories.ReservationStateRepository;

@Service
public class SearcReservationStateByIdService {
  

  @Autowired
  private ReservationStateRepository reservationStateRepository;


  public  ReservationState searchById(Long id) {
    return reservationStateRepository.findById(id).orElse(null);
  }

}
