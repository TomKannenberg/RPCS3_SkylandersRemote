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

    public enum GLanderType {
        Default((byte) 0),
        SwapperTop((byte) 1),
        SwapperBottom((byte) 2),
        Special1((byte) 3),
        Special2((byte) 4);

        private final byte value;

        GLanderType(byte value) {
            this.value = value;
        }

        public byte getValue() {
            return value;
        }
        }


    public int image;
    public GLanderElement element;
    public String name;
    public GLanderType type;

    GLander(int image, String name, GLanderElement element) {
        super(image, name);
        this.image = image;
        this.name = name;
        this.element = element;
        this.type = GLanderType.Default;
        bottomForeground = false;
    }

    GLander(int image, String name, GLanderElement element, GLanderType type) {
        super(image, name, type == GLanderType.SwapperBottom);
        this.image = image;
        this.name = name;
        this.element = element;
        this.type = type;
        bottomForeground = false;
    }

    GLander(int image, String name, GLanderElement element, GLanderType type, boolean bottomForeground) {
        super(image, name, type == GLanderType.SwapperBottom);
        this.image = image;
        this.name = name;
        this.element = element;
        this.type = type;
        bottomForeground = bottomForeground;
    }
}
