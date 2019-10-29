package com.mowitnow.objects;

public class Field {

    private int length;
    private int width;

    public Field(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return "Field {" +
                "length = " + this.length +
                ", width = " + this.width +
                '}';
    }

    public boolean checkFieldLength(int i) {
        return (this.length + i < this.length) && (this.length + i >= 0);
    }

    public boolean checkFieldWidth(int i) {
        return (this.width + i < this.width) && (this.width + i >= 0);
    }
}
