package com.hotels.mart.application.services.cardmembership;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.mart.domain.entities.CardMembership;
import com.hotels.mart.infrastructure.jpa.repositories.CardMembershipRepository;

@Service
public class CreateCardMembershipService {
  @Autowired
  private CardMembershipRepository cardmembershipRepository;

  public void createCardMembership(CardMembership cardmembership) {
    cardmembershipRepository.save(cardmembership);
  }

}
