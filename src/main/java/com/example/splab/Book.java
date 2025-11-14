// src/main/java/com/example/splab/Book.java
package com.example.splab;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.persistence.Table;


import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties({"elements"})
@Entity
@Table(name = "books")
public class Book extends Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(
            name = "book_authors",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private List<Author> authors = new ArrayList<>();

    public Book() {
        super("");
    }

    public Book(String title) {
        super("Book: " + title);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        if (title == null) return null;
        return title.startsWith("Book: ") ? title.substring(6) : title;
    }

    public void setTitle(String t) {
        this.title = (t == null || t.isBlank()) ? "" : "Book: " + t.trim();
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = (authors != null) ? authors : new ArrayList<>();
    }

    public void addAuthor(Author author) {
        if (author != null) authors.add(author);
    }

    public void print() {
        System.out.println(title);
        System.out.println();
        System.out.println("Authors:");
        for (Author author : authors) {
            author.print();
            System.out.println();
        }
        for (Element element : super.elements) {
            element.print();
        }
    }
}
