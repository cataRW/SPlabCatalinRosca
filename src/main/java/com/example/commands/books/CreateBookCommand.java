package com.example.commands.books;

import com.example.commands.Command;
import com.example.services.BooksService;
import com.example.splab.Book;

public class CreateBookCommand implements Command<Book> {
    private final BooksService svc;
    private final Book payload;

    public CreateBookCommand(BooksService svc, Book payload) {
        this.svc = svc; this.payload = payload;
    }

    @Override
    public Book execute() {
        return svc.create(payload);
    }
}
