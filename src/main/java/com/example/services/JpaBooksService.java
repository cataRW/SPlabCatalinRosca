// src/main/java/com/example/services/JpaBooksService.java
package com.example.services;

import com.example.persistence.BooksRepository;
import com.example.splab.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JpaBooksService implements BooksService {

    private final BooksRepository repo;

    public JpaBooksService(BooksRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Book> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public Book create(Book book) {
        // id e generat de DB (GeneratedValue)
        return repo.save(book);
    }

    @Override
    public Optional<Book> replace(Long id, Book replacement) {
        if (!repo.existsById(id)) return Optional.empty();
        replacement.setId(id);
        return Optional.of(repo.save(replacement));
    }

    @Override
    public boolean delete(Long id) {
        if (!repo.existsById(id)) return false;
        repo.deleteById(id);
        return true;
    }
}
