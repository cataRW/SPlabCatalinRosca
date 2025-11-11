package com.example.controllers;

import com.example.async.AsyncCommandExecutor;
import com.example.commands.CommandExecutor;
import com.example.commands.books.*;
import com.example.services.BooksService;
import com.example.splab.Book;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {

    private final BooksService booksService;
    private final CommandExecutor executor;
    private final AsyncCommandExecutor asyncExecutor;

    public BooksController(
            BooksService booksService,
            CommandExecutor executor,
            AsyncCommandExecutor asyncExecutor
    ) {
        this.booksService = booksService;
        this.executor = executor;
        this.asyncExecutor = asyncExecutor;
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAll(@RequestParam(defaultValue = "false") boolean async) {
        var cmd = new GetAllBooksCommand(booksService);

        if (!async) {
            return ResponseEntity.ok(executor.execute(cmd));
        }

        long jobId = asyncExecutor.submit(cmd);
        return ResponseEntity
                .accepted()
                .location(URI.create("/jobs/" + jobId))
                .build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id,
                                     @RequestParam(defaultValue = "false") boolean async) {
        var cmd = new GetBookByIdCommand(booksService, id);

        if (!async) {
            return executor.execute(cmd)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        }

        long jobId = asyncExecutor.submit(cmd);
        return ResponseEntity
                .accepted()
                .location(URI.create("/jobs/" + jobId))
                .build();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Book payload,
                                    @RequestParam(defaultValue = "false") boolean async) {
        var cmd = new CreateBookCommand(booksService, payload);

        if (!async) {
            var created = executor.execute(cmd);
            return ResponseEntity
                    .created(URI.create("/books/" + created.getId()))
                    .body(created);
        }

        long jobId = asyncExecutor.submit(cmd);
        return ResponseEntity
                .accepted()
                .location(URI.create("/jobs/" + jobId))
                .build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> replace(@PathVariable Long id,
                                     @RequestBody Book payload,
                                     @RequestParam(defaultValue = "false") boolean async) {
        var cmd = new UpdateBookCommand(booksService, id, payload);

        if (!async) {
            return executor.execute(cmd)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        }

        long jobId = asyncExecutor.submit(cmd);
        return ResponseEntity
                .accepted()
                .location(URI.create("/jobs/" + jobId))
                .build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id,
                                    @RequestParam(defaultValue = "false") boolean async) {
        var cmd = new DeleteBookCommand(booksService, id);

        if (!async) {
            boolean ok = executor.execute(cmd);
            return ok ? ResponseEntity.noContent().build()
                    : ResponseEntity.notFound().build();
        }

        long jobId = asyncExecutor.submit(cmd);
        return ResponseEntity
                .accepted()
                .location(URI.create("/jobs/" + jobId))
                .build();
    }
}
