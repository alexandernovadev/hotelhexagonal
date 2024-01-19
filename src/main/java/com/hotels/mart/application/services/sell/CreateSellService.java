package com.hotels.mart.application.services.sell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.mart.domain.entities.Sell;
import com.hotels.mart.infrastructure.jpa.repositories.BookRepository;
import com.hotels.mart.infrastructure.jpa.repositories.CardMembershipRepository;
import com.hotels.mart.infrastructure.jpa.repositories.SellRepository;
import com.hotels.mart.infrastructure.jpa.repositories.UserRepository;

@Service
public class CreateSellService {
  @Autowired
  private SellRepository sellRepository;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private BookRepository bookRepository;

  @Autowired
  private CardMembershipRepository cardmembershipRepository;

  public void createSell(Sell sell) {
    // Verify if user exist
    // Verify if books are avaliables
    // Calculate all balance sum all books and verify it

    // Veriry if user has memership
       // Verify if user has balance

    // If all is valid, save sell 

    sellRepository.save(sell);
  }

}
