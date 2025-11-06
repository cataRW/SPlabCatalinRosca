package com.example.splab;

class Image implements Element {
    String url;

    public Image(String imageName){
        this.url = imageName;
    }

    public void print(){
        System.out.println("Image with name: " + url);
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
