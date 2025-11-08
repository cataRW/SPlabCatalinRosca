package com.example.splab;

public class Context {
    public int lineWidth;

    public Context(int lineWidth) {
        this.lineWidth = Math.max(0, lineWidth);
    }

    public int getLineWidth() {
        return lineWidth;
    }
}
