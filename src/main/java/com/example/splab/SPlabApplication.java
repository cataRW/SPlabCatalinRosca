package com.example.splab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.splab.*;   // sau importuri pe clasele tale



@SpringBootApplication
public class SPlabApplication {

    public static void main(String[] args) {
        Book book = new Book("Noapte buna, copii!");
        book.addAuthor(new Author("Radu Pavel", "Gheo"));

        Section cap1   = new Section("Capitolul 1");
        Section cap11  = new Section("Capitolul 1.1");
        Section cap111 = new Section("Capitolul 1.1.1");
        Section cap1111= new Section("Subchapter 1.1.1.1");

        book.add(new Paragraph("Multumesc celor care ..."));
        book.add(cap1);

        cap1.add(new Paragraph("Moto capitol"));
        cap1.add(cap11);

        cap11.add(new Paragraph("Text from subchapter 1.1"));
        cap11.add(cap111);

        cap111.add(new Paragraph("Text from subchapter 1.1.1"));
        cap111.add(cap1111);

        cap1111.add(new Image("Image subchapter 1.1.1.1"));

                // ex. și un cuprins minimal
        book.add(new TableOfContents("...auto-generated later..."));

        book.print();
    }
}
