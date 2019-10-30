package com.mowitnow;

import com.mowitnow.objects.Field;
import com.mowitnow.objects.Mower;
import com.mowitnow.data.ActionEnum;
import com.mowitnow.data.OrientationEnum;

public class MowerAction {

    Mower mower;
    Field field;

    public MowerAction(Mower mower, Field field) {
        this.mower = mower;
        this.field = field;
    }

    public void analyseAction(ActionEnum action) {
        if (ActionEnum.isRotation(action)) {
            updateOrientation(action);
        } else {
            moveMower();
        }
    }

    private void moveMower() {
        if (mower.getOrientation().equals(OrientationEnum.N) && field.checkFieldWidth(mower.getPositionAxisY() + 1)) {
            mower.moveTowardNorth();
        } else if (mower.getOrientation().equals(OrientationEnum.S) && field.checkFieldWidth(mower.getPositionAxisY() - 1)) {
            mower.moveTowardSouth();
        } else if (mower.getOrientation().equals(OrientationEnum.W) && field.checkFieldLength(mower.getPositionAxisX() - 1)) {
            mower.moveTowardWest();
        } else if (mower.getOrientation().equals(OrientationEnum.E) && field.checkFieldLength(mower.getPositionAxisX() + 1)) {
            mower.moveTowardEast();
        }
    }

    private void updateOrientation(ActionEnum action) {
        mower.setOrientation(ActionEnum.next(mower.getOrientation(), action));
    }
}
