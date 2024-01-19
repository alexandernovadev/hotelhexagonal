package com.hotels.mart.application.services.cardmembership;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.mart.domain.entities.CardMembership;
import com.hotels.mart.infrastructure.jpa.repositories.CardMembershipRepository;

@Service
public class GetAllCardMembershipService {
  @Autowired
  private CardMembershipRepository cardmembershipRepository;

  public  List<CardMembership> getAllCardMemberships() {
    return cardmembershipRepository.findAll();
  }
}
