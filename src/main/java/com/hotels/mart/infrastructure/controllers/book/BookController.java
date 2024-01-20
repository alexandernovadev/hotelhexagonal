package com.hotels.mart.infrastructure.controllers.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotels.mart.application.services.book.GetAllBookService;
import com.hotels.mart.application.services.user.DeleteUserService;

@RestController
@RequestMapping("/api/books")
public class BookController {

  @Autowired
  private GetAllBookService getAllBookService;

  @GetMapping
  public ResponseEntity<?> getBooks() {
    return new ResponseEntity<>(getAllBookService.getAllBooks(), HttpStatus.OK);
  }
}
