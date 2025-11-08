package com.example.splab;


public class AlignRight implements AlignStrategy{

    @Override
    public void render(Paragraph paragraph, Context context) {
        String text = paragraph.getText();
        int pad = Math.max(0, context.getLineWidth() - text.length());

        System.out.println("[Right]  " + " ".repeat(pad) + text);
    }
}