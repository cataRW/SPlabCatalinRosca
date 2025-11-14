// src/main/java/com/example/splab/Section.java
package com.example.splab;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Transient;

import java.util.ArrayList;
import java.util.List;

@MappedSuperclass
public class Section extends ParentElement implements Element {
    protected String title;

    @Transient
    protected List<Element> elements = new ArrayList<>();

    public Section(String title) {
        this.title = title;
    }

    public Section() { }

    @Override
    public void print() {
        System.out.println(title);
        for (Element element : elements) {
            element.print();
        }
    }

    @Override
    public void add(Element element) {
        if (element instanceof ParentElement be) {
            if (be.getParent() != null && be.getParent() != this) {
                throw new IllegalStateException("Element is already part of another Section.");
            }
            be.setParent(this);
        }
        elements.add(element);
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
