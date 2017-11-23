package com.android.neo.tp.helpers.models;

/**
 * Created by neo on 26/10/17.
 */

public class Download {
    private String text;
    private String header;

    public Download(String text, String header) {
        this.text = text;
        this.header = header;
    }

    public String getHeader() {

        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Download(String text) {

        this.text = text;
    }
}
