package com.example.splab;

import javax.swing.*;

public class Paragraph extends ParentElement implements Element {
    String text;
    private AlignStrategy alignStrategy;

    public Paragraph(String text) {
        this.text = text;
    }

    public void print(){
        if (alignStrategy == null) {
            System.out.println("Paragraph: " + text);
        } else {
            alignStrategy.render(this, new Context(50));
        }
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

     public String getText() {
        return text;
     }
 }
