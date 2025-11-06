package com.example.splab;

public class Table extends ParentElement implements Element {
    String title;

    public void print(){
        System.out.println("com.example.splab.Table: " + title);
    }

    public Table(String title){
        this.title = title;
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
