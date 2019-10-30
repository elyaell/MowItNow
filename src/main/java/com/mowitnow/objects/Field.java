package com.mowitnow.objects;

public class Field {

    private int length;
    private int width;

    public Field(int length, int width) {
        this.length = length + 1;
        this.width = width + 1;
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

    /**
     * Check if new position X (WestEast axis) is within boundaries
     * @param positionX new position X
     * @return if the position is allowed
     */
    public boolean checkFieldLength(int positionX) {
        return (positionX < this.length) && (positionX >= 0);
    }

    /**
     * Check if new position Y (NorthSouth axis) is within boundaries
     * @param positionY new position Y
     * @return if the position is allowed
     */
    public boolean checkFieldWidth(int positionY) {
        return (positionY < this.width) && (positionY >= 0);
    }

    @Override
    public String toString() {
        return "(" + (this.length - 1) + ", " + (this.width - 1) + ")";
    }
}
