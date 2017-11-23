package com.android.neo.tp.helpers.models;


import android.widget.ImageView;

public class Test {
    private int image;
    private String text;

    public Test(String text, int image) {
        this.text = text;
        this.image = image;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
