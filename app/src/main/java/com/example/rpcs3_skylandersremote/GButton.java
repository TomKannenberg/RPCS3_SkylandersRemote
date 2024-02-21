package com.example.rpcs3_skylandersremote;

public class GButton {
    private int imageResource;
    private String text;

    public boolean low;
    public boolean swapper;
    public boolean bottomForeground = false;

    public GButton(int imageResource, String text) {
        this.imageResource = imageResource;
        this.text = text;
        this.low = false;
        this.swapper = false;
    }

    public GButton(int imageResource, String text, boolean low) {
        this.imageResource = imageResource;
        this.text = text;
        this.low = low;
        this.swapper = true;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getText() {
        return text;
    }
}
