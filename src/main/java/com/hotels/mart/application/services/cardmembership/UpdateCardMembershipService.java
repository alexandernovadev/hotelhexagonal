package com.hotels.mart.application.services.cardmembership;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.mart.domain.entities.CardMembership;
import com.hotels.mart.infrastructure.jpa.repositories.CardMembershipRepository;

@Service
public class UpdateCardMembershipService {
  
  @Autowired
  private CardMembershipRepository uexRepository;

  public void updateCardMembership(CardMembership uex) {
    uexRepository.save(uex);
  }
}