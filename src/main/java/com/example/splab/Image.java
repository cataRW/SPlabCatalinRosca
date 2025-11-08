package com.example.splab;

class Image {
    String url;

    public Image(String imageName){
        this.url = imageName;
    }

    public void print(){
        System.out.println("Image with name: " + url);
    }

 }
