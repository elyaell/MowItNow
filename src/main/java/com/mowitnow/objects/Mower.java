package com.mowitnow.objects;

import com.mowitnow.data.OrientationEnum;

public class Mower {
    private int positionAxisX;
    private int positionAxisY;
    private OrientationEnum orientation;

    public Mower(int axisX, int axisY, OrientationEnum orientation) {
        this.positionAxisX = axisX;
        this.positionAxisY = axisY;
        this.orientation = orientation;
    }

    public int getPositionAxisX() {
        return positionAxisX;
    }

    public void setPositionAxisX(int positionAxisX) {
        this.positionAxisX = positionAxisX;
    }

    public int getPositionAxisY() {
        return positionAxisY;
    }

    public void setPositionAxisY(int positionAxisY) {
        this.positionAxisY = positionAxisY;
    }

    public OrientationEnum getOrientation() {
        return orientation;
    }

    public void setOrientation(OrientationEnum orientation) {
        this.orientation = orientation;
    }

    @Override
    public String toString() {
        return "Mower {" +
                "positionAxisX = " + positionAxisX +
                ", positionAxisY = " + positionAxisY +
                ", orientation = " + orientation +
                '}';
    }
}
