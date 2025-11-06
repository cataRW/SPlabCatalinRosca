package com.example.splab;

interface Element {
    void print();

    void add(Element element);
    void remove(Element element);
    Element get(int index);

}
