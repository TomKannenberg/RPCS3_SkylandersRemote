package com.example.rpcs3_skylandersremote;

public class GButton {
    private int imageResource;
    private String text;

    public GButton(int imageResource, String text) {
        this.imageResource = imageResource;
        this.text = text;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getText() {
        return text;
    }
}
