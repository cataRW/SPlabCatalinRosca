package com.example.commands.books;

import com.example.commands.Command;
import com.example.services.BooksService;
import com.example.splab.Book;

import java.util.List;

public class GetAllBooksCommand implements Command<List<Book>> {
    private final BooksService svc;

    public GetAllBooksCommand(BooksService svc) {
        this.svc = svc;
    }

    @Override
    public List<Book> execute() {
        return svc.findAll();
    }
}
