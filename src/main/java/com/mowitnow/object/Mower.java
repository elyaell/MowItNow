package com.mowitnow.object;

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
}
