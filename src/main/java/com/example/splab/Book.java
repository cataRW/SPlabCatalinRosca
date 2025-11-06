package com.example.splab;

import java.util.ArrayList;
import java.util.List;

public class Book extends Section {
    public List<Author> authors = new ArrayList<>();

    public Book(String title){
        super("Book: " + title);
    }

    public void addAuthor(Author author){
        if(author != null) {
            authors.add(author);
        }
    }

    public void print(){
        System.out.println(title);
        System.out.println();
        System.out.println("Authors:");

        for(Author author : authors){
            author.print();
            System.out.println();
        }

        for(Element element : super.elements){
            element.print();
        }
    }
}
