package com.example.splab;

public class Paragraph extends ParentElement implements Element {
    String text;

    public Paragraph(String text) {
        this.text = text;
    }

    public void print(){
        System.out.println("Paragraph: " + text);
    }

     @Override
     public void add(Element element) {

     }

     @Override
     public void remove(Element element) {

     }

     @Override
     public Element get(int index) {
         return null;
     }
 }
