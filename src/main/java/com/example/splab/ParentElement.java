package com.example.splab;

public abstract class ParentElement implements Element{
    public Section parent = null;

    public Section getParent() {
        return parent;
    }

    protected void setParent(Section p) {
        this.parent = p;
    }
}

