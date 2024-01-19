package com.hotels.mart.application.services.cardmembership;
import org.springframework.stereotype.Service;

import com.hotels.mart.domain.entities.CardMembership;
import com.hotels.mart.infrastructure.jpa.repositories.CardMembershipRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
@Service
public class GetCardMembershipByIdService {
  @Autowired
  private CardMembershipRepository cardmembershipRepository;

  public Optional<CardMembership> getCardMembershipById(Integer id) {
    return cardmembershipRepository.findById(id);
  }
  
}







