package com.mowitnow.objects;

import com.mowitnow.util.ActionEnum;
import com.mowitnow.util.OrientationEnum;

import java.util.List;

public class Mower {
    int positionAxisX;
    int positionAxisY;
    OrientationEnum orientation;
    List<ActionEnum> actions;

    public Mower(int axisX, int axisY, OrientationEnum orientation, List<ActionEnum> actions) {
        this.positionAxisX = axisX;
        this.positionAxisY = axisY;
        this.orientation = orientation;
        this.actions = actions;
    }

    @Override
    public String toString() {
        return "Mower {" +
                "positionAxisX = " + positionAxisX +
                ", positionAxisY = " + positionAxisY +
                ", orientation = " + orientation +
                ", actions = " + actions.toString() +
                '}';
    }
}
