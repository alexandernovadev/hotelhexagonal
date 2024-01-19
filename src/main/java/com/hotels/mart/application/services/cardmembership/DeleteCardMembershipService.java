package com.hotels.mart.application.services.cardmembership;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.mart.infrastructure.jpa.repositories.CardMembershipRepository;

@Service
public class DeleteCardMembershipService {
  @Autowired
  private CardMembershipRepository cardmembershipRepository;

  public void deleteCardMembership(Integer id) {
    cardmembershipRepository.deleteById(id);
  }
}
