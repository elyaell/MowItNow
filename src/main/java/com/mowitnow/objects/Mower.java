package com.mowitnow.objects;

import com.mowitnow.data.OrientationEnum;
import com.mowitnow.exception.MowItNowException;

public class Mower {
    private int positionAxisX;
    private int positionAxisY;
    private OrientationEnum orientation;

    public Mower(int axisX, int axisY, OrientationEnum orientation) {
        this.positionAxisX = axisX;
        this.positionAxisY = axisY;
        this.orientation = orientation;
    }

    public Mower(String axisX, String axisY, String orientation) throws MowItNowException {
        this.positionAxisX = Integer.parseInt(axisX);
        this.positionAxisY = Integer.parseInt(axisY);
        this.orientation = OrientationEnum.parse(orientation);
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

    /**
     * North is axis Y ++
     */
    public void moveTowardNorth() {
        this.positionAxisY++;
    }

    /**
     * East is axis X ++
     */
    public void moveTowardEast() {
        this.positionAxisX++;
    }

    /**
     * West is axis X --
     */
    public void moveTowardWest() {
        this.positionAxisX--;
    }

    /**
     * South is axis Y --
     */
    public void moveTowardSouth() {
        this.positionAxisY--;
    }

    @Override
    public String toString() {
        return "(" + this.positionAxisX + " " + this.positionAxisY + " " + this.orientation + ")";
    }
}
