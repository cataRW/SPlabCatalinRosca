package com.example.services;

import com.example.splab.Book;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class InMemoryBooksService implements BooksService {
    private final Map<Long, Book> repo = new ConcurrentHashMap<>();
    private final AtomicLong seq = new AtomicLong(0);

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(repo.values());
    }

    @Override
    public Optional<Book> findById(Long id) {
        return Optional.ofNullable(repo.get(id));
    }

    @Override
    public Book create(Book book) {
        long id = seq.incrementAndGet();
        book.setId(id);
        repo.put(id, book);
        return book;
    }

    @Override
    public Optional<Book> replace(Long id, Book replacement) {
        if (!repo.containsKey(id)) {
            return Optional.empty();
        }
        replacement.setId(id);
        repo.put(id, replacement);
        return Optional.of(replacement);
    }

    @Override
    public boolean delete(Long id) {
        return repo.remove(id) != null;
    }
}
