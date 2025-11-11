package com.example.splab;

public class Author {
    String name;
    String suname;

    public Author() {}
    public Author(String name, String suname) {
        this.name = name;
        this.suname = suname;
    }

    void print(){
        System.out.println("Author: " + name + " " + suname);
    }
}
