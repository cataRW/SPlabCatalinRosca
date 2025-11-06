package com.example.splab;

import java.util.ArrayList;
import java.util.List;

public class Section implements Element {
    String title;
    List<Element> elements = new ArrayList<>();

    public Section(String title) {
        this.title = title;
    }

    @Override
    public void print() {
        System.out.println(title);
        for (Element element : elements) {
            element.print();
        }
    }

    @Override
    public void add(Element element) {
        if (element != null) {
            elements.add(element);
        }
    }

    @Override
    public void remove(Element element) {
        elements.remove(element);
    }

    @Override
    public Element get(int index) {
        return elements.get(index);
    }
}
