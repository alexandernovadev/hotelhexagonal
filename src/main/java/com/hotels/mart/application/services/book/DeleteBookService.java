package com.hotels.mart.application.services.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.mart.infrastructure.jpa.repositories.BookRepository;

@Service
public class DeleteBookService {
  @Autowired
  private BookRepository bookRepository;

  public void deleteBook(Integer id) {
    bookRepository.deleteById(id);
  }
}
