package com.example.services;

import com.example.splab.Book;

import java.util.List;
import java.util.Optional;

public interface BooksService {
    List<Book> findAll();
    Optional<Book> findById(Long id);
    Book create(Book book);
    Optional<Book> replace(Long id, Book replacement);
    boolean delete(Long id);
}
