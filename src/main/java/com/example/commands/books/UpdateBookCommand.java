package com.example.commands.books;

import com.example.commands.Command;
import com.example.services.BooksService;
import com.example.splab.Book;

import java.util.Optional;

public class UpdateBookCommand implements Command<Optional<Book>> {
    private final BooksService svc;
    private final Long id;
    private final Book replacement;

    public UpdateBookCommand(BooksService svc, Long id, Book replacement) {
        this.svc = svc; this.id = id; this.replacement = replacement;
    }

    @Override
    public Optional<Book> execute() {
        return svc.replace(id, replacement);
    }
}
