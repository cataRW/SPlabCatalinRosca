package com.example.commands.books;

import com.example.commands.Command;
import com.example.services.BooksService;

public class DeleteBookCommand implements Command<Boolean> {
    private final BooksService svc;
    private final Long id;

    public DeleteBookCommand(BooksService svc, Long id) {
        this.svc = svc; this.id = id;
    }

    @Override
    public Boolean execute() {
        return svc.delete(id);
    }
}
