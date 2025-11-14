package com.example.services;

import com.example.splab.Book;

import java.util.*;

public class InMemoryBooksService implements BooksService {

    private final Map<Long, Book> data = new HashMap<>();
    private long nextId = 1;

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(data.values());
    }

    @Override
    public Optional<Book> findById(Long id) {
        return Optional.ofNullable(data.get(id));
    }

    @Override
    public Book create(Book book) {
        long id = nextId++;
        book.setId(id);
        data.put(id, book);
        return book;
    }

    @Override
    public Optional<Book> replace(Long id, Book replacement) {
        if (!data.containsKey(id)) {
            return Optional.empty();
        }
        replacement.setId(id);
        data.put(id, replacement);
        return Optional.of(replacement);
    }

    @Override
    public boolean delete(Long id) {
        return data.remove(id) != null;
    }
}
