package com.example.rpcs3_skylandersremote;

public class GLander extends GButton {

    enum GLanderElement {
        Air,
        Dark,
        Earth,
        Fire,
        Kaos,
        Life,
        Light,
        Magic,
        Tech,
        Undead,
        Water,
        None
    }

    public int image;
    public GLanderElement element;
    public String name;

    GLander(int image, String name, GLanderElement element) {
        super(image, name);
        this.image = image;
        this.name = name;
        this.element = element;
    }
}
