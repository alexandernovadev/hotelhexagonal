package com.hotels.mart.infrastructure.jpa.repositories;

import com.hotels.mart.domain.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository  extends JpaRepository<Book, Integer> {

}