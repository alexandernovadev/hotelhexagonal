package com.hotels.mart.application.services.sell;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hotels.mart.application.dto.PurshaseDto;
import com.hotels.mart.application.dto.ResponseFormat;
import com.hotels.mart.domain.entities.Book;
import com.hotels.mart.domain.entities.CardMembership;
import com.hotels.mart.domain.entities.DetailSell;
import com.hotels.mart.domain.entities.Sell;
import com.hotels.mart.infrastructure.jpa.repositories.BookRepository;
import com.hotels.mart.infrastructure.jpa.repositories.CardMembershipRepository;
import com.hotels.mart.infrastructure.jpa.repositories.DetailSellRepository;
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
  private DetailSellRepository detailSellRepository;

  @Autowired
  private CardMembershipRepository cardmembershipRepository;

  public ResponseFormat createSell(PurshaseDto purchaseDto) {

    /*
     * Validate DTO
     */
    if (purchaseDto.getUser_id() <= 0) {
      return new ResponseFormat("Invalid user ID", HttpStatus.BAD_REQUEST.value(), LocalDateTime.now());
    }

    if (purchaseDto.getNumber_card() <= 0) {
      return new ResponseFormat("Invalid card number", HttpStatus.BAD_REQUEST.value(), LocalDateTime.now());
    }

    if (purchaseDto.getBooks() == null || purchaseDto.getBooks().isEmpty()) {
      return new ResponseFormat("No books provided in the purchase", HttpStatus.BAD_REQUEST.value(),
          LocalDateTime.now());
    }

    /*
     * Validate if user exists
     */
    Long userId = Long.valueOf(purchaseDto.getUser_id());
    if (!userRepository.existsById(userId)) {
      return new ResponseFormat("User does not exist", HttpStatus.BAD_REQUEST.value(), LocalDateTime.now());
    }

    /*
     * Validate if books exist and if there is a sufficient amount.
     */
    for (PurshaseDto.BookAmount bookAmount : purchaseDto.getBooks()) {

      Integer bookId = Integer.valueOf(bookAmount.getId());

      Optional<Book> bookOpt = bookRepository.findById(bookId);
      if (!bookOpt.isPresent()) {
        return new ResponseFormat("Book with ID " + bookAmount.getId() + " does not exist",
            HttpStatus.BAD_REQUEST.value(), LocalDateTime.now());
      }

      Book book = bookOpt.get();
      if (book.getAmount() < bookAmount.getAmount()) {
        return new ResponseFormat("Insufficient quantity for book with ID " + bookAmount.getId(),
            HttpStatus.BAD_REQUEST.value(), LocalDateTime.now());
      }
    }

    if (!cardmembershipRepository.existsById(purchaseDto.getNumber_card())) {
      return new ResponseFormat("Invalid card number", HttpStatus.BAD_REQUEST.value(), LocalDateTime.now());
    }

    /*
     * Validate if the balance covers the total cost of all the books.
     */

    // Step 1 Calculate the total cost of the books.
    BigDecimal totalCost = BigDecimal.ZERO;
    for (PurshaseDto.BookAmount bookAmount : purchaseDto.getBooks()) {
      Optional<Book> bookOpt = bookRepository.findById(Integer.valueOf(bookAmount.getId()));
      if (bookOpt.isPresent()) {
        Book book = bookOpt.get();
        BigDecimal cost = book.getPrice().multiply(BigDecimal.valueOf(bookAmount.getAmount()));
        totalCost = totalCost.add(cost);
      }
    }

    // Step 2: Get card balance
    Optional<CardMembership> cardMembershipOpt = cardmembershipRepository.findById(purchaseDto.getNumber_card());
    if (!cardMembershipOpt.isPresent()) {
      return new ResponseFormat("Card not found", HttpStatus.BAD_REQUEST.value(), LocalDateTime.now());
    }
    CardMembership cardMembership = cardMembershipOpt.get();
    BigDecimal cardBalance = cardMembership.getBalance();

    // Step 3: Compare the balance with the total cost.
    if (cardBalance.compareTo(totalCost) < 0) {
      return new ResponseFormat(
          "Insufficient balance on the card, you have " + cardBalance + " and your purchase totals " + totalCost,
          HttpStatus.BAD_REQUEST.value(),
          LocalDateTime.now());
    }

    // LAST STEP

    // Step 1: Decrease book quantities in the inventory
    for (PurshaseDto.BookAmount bookAmount : purchaseDto.getBooks()) {
      Optional<Book> bookOpt = bookRepository.findById(Integer.valueOf(bookAmount.getId()));
      if (bookOpt.isPresent()) {
        Book book = bookOpt.get();
        Integer newAmount = book.getAmount() - bookAmount.getAmount();
        book.setAmount(newAmount);
        bookRepository.save(book); // Guardar el libro actualizado en la base de datos
      }
    }

    // Step 2, restar balance del card
    BigDecimal newBalance = cardMembership.getBalance().subtract(totalCost);
    cardMembership.setBalance(newBalance);
    cardmembershipRepository.save(cardMembership);

    // Step 3 Register Purchase
    Sell sell = new Sell();
    sell.setUser(userRepository.findById(userId).get());
    sell.setBalance(totalCost);
    sell.setState("Completed");
    sell.setCreated_at(LocalDateTime.now());
    sell = sellRepository.save(sell);

    /*
     * Register all details
     */

    for (PurshaseDto.BookAmount bookAmount : purchaseDto.getBooks()) {
      DetailSell detailSell = new DetailSell();
      detailSell.setSell(sell);
      detailSell.setBook(bookRepository.findById(Integer.valueOf(bookAmount.getId())).get());
      detailSell.setAmount(bookAmount.getAmount());
      detailSell.setPrice(detailSell.getBook().getPrice().multiply(BigDecimal.valueOf(bookAmount.getAmount())));
      detailSell.setCreated_at(LocalDateTime.now());
      detailSellRepository.save(detailSell); // Guardar el detalle de la venta en la base de datos
    }

    ResponseFormat responseFormat = new ResponseFormat(
        "The purshase goes succesfully",
        HttpStatus.ACCEPTED.value(),
        LocalDateTime.now());

    return responseFormat;
  }

}
