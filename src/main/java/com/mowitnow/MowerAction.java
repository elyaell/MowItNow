package com.mowitnow;

import com.mowitnow.objects.Field;
import com.mowitnow.objects.Mower;
import com.mowitnow.data.ActionEnum;
import com.mowitnow.data.OrientationEnum;

public class MowerAction {

    private Mower mower;
    private Field field;

    public MowerAction(Mower mower, Field field) {
        this.mower = mower;
        this.field = field;
    }

    /**
     * Analyse the action and call the function corresponding to the detected action
     * @param action the action to do
     */
    public void analyseAction(ActionEnum action) {
        if (ActionEnum.isRotation(action)) {
            updateOrientation(action);
        } else {
            moveMower();
        }
    }

    /**
     * Move the mower depending of its orientation and actual position.
     * There is 4 extremes cases :
     *  - (0,0) : the mower can only go EAST and NORTH
     *  - (0,5) : the mower can only go EAST and SOUTH
     *  - (5,0) : the mower can only go WEST and NORTH
     *  - (5,5) : the mower can only go WEST and SOUTH
     * If the mower is in one of the preceding positions and in one of the forbidden direction, then the positions
     * won't be updated.
     */
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

    /**
     * Update the orientation of the mower.
     * The instruction should be G or D.
     *
     * @param action the instruction.
     */
    private void updateOrientation(ActionEnum action) {
        mower.setOrientation(ActionEnum.next(mower.getOrientation(), action));
    }
}
