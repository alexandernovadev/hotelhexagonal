package com.hotels.mart.infrastructure.jpa.repositories;

import com.hotels.mart.domain.entities.Book;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
  Optional<Book> findById(Integer bookId);
}