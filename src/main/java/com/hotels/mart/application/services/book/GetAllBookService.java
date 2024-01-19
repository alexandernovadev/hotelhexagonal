package com.hotels.mart.application.services.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.mart.domain.entities.Book;
import com.hotels.mart.infrastructure.jpa.repositories.BookRepository;

@Service
public class GetAllBookService {
  @Autowired
  private BookRepository bookRepository;

  public  List<Book> getAllBooks() {
    return bookRepository.findAll();
  }
}
