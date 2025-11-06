package com.example.splab;

public class TableOfContents implements Element{
    String content;

    public TableOfContents(String content) {
        this.content = content;
    }

    public void print(){
        if(content != null) {
            System.out.println(content);
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
}
