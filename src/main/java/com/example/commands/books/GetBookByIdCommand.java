package com.example.commands.books;

import com.example.commands.Command;
import com.example.services.BooksService;
import com.example.splab.Book;

import java.util.Optional;

public class GetBookByIdCommand implements Command<Optional<Book>> {
    private final BooksService svc;
    private final Long id;

    public GetBookByIdCommand(BooksService svc, Long id) {
        this.svc = svc; this.id = id;
    }

    @Override
    public Optional<Book> execute() {
        return svc.findById(id);
    }
}
