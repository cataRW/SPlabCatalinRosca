package com.example.splab;



public class AlignLeft implements AlignStrategy{

    @Override
    public void render(Paragraph paragraph, Context context) {
        System.out.println("[Left]   " + paragraph.getText());
    }
}
