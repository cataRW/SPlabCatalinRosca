package com.example.splab;

public class ImageProxy implements Element{
    public String url;
    private Image realImg;

    public ImageProxy(String url) {
        this.url = url;
    }

    private Image laodImage() {
        if (realImg == null) {
            realImg = new Image(url);
        }
        return realImg;
    }

    @Override
    public void print() {

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
