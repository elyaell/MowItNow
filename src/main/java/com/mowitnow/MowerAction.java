package com.mowitnow;

import com.mowitnow.objects.Field;
import com.mowitnow.objects.Mower;
import com.mowitnow.util.ActionEnum;
import com.mowitnow.util.OrientationEnum;

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
        if (mower.getOrientation().equals(OrientationEnum.N) && field.checkFieldLength(mower.getPositionAxisX() + 1)) {
            mower.setPositionAxisX(1);
        } else if (mower.getOrientation().equals(OrientationEnum.S) && field.checkFieldLength(mower.getPositionAxisX() - 1)) {
            mower.setPositionAxisX(-1);
        } else if (mower.getOrientation().equals(OrientationEnum.W) && field.checkFieldWidth(mower.getPositionAxisY() - 1)) {
            mower.setPositionAxisY(-1);
        } else if (mower.getOrientation().equals(OrientationEnum.E) && field.checkFieldWidth(mower.getPositionAxisY() + 1)) {
            mower.setPositionAxisY(1);
        }
    }

    private void updateOrientation(ActionEnum action) {
        mower.setOrientation(ActionEnum.next(mower.getOrientation(), action));
    }
}
