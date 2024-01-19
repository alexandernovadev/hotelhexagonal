package com.hotels.mart.application.services.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.mart.domain.entities.Book;
import com.hotels.mart.infrastructure.jpa.repositories.BookRepository;

@Service
public class UpdateBookService {
  
  @Autowired
  private BookRepository uexRepository;

  public void updateBook(Book uex) {
    uexRepository.save(uex);
  }
}