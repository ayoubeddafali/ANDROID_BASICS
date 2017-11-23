package com.android.neo.tp.helpers.models;


import com.android.neo.tp.R;

public class Article {
    private int image = R.drawable.nature;
    private String text;

    public Article(String text, int image) {
        this.text = text;
        this.image = image;
    }

    public Article(String text) {
        this.text = text;
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
