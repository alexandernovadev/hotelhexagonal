package com.hotels.mart.application.services.book;
import org.springframework.stereotype.Service;

import com.hotels.mart.domain.entities.Book;
import com.hotels.mart.infrastructure.jpa.repositories.BookRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
@Service
public class GetBookByIdService {
  @Autowired
  private BookRepository bookRepository;

  public Optional<Book> getBookById(Integer id) {
    return bookRepository.findById(id);
  }
  
}







