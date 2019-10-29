package com.mowitnow;

import com.mowitnow.objects.Field;
import com.mowitnow.objects.Mower;
import com.mowitnow.data.ActionEnum;
import com.mowitnow.data.OrientationEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class MowerActionTest {

    Mower mower;
    Field field;
    MowerAction mowerAction;

    @BeforeEach
    void setUp() {
        mower = new Mower(0, 0, OrientationEnum.N);
        field = new Field(5, 5);
        mowerAction = new MowerAction(mower, field);
    }

    @Test
    void analyseAction_if_action_is_always_G() {
        mowerAction.analyseAction(ActionEnum.G);
        assertEquals(OrientationEnum.W, mower.getOrientation());
        mowerAction.analyseAction(ActionEnum.G);
        assertEquals(OrientationEnum.S, mower.getOrientation());
        mowerAction.analyseAction(ActionEnum.G);
        assertEquals(OrientationEnum.E, mower.getOrientation());
        mowerAction.analyseAction(ActionEnum.G);
        assertEquals(OrientationEnum.N, mower.getOrientation());
    }

    @Test
    void analyseAction_if_action_is_always_D() {
        mowerAction.analyseAction(ActionEnum.D);
        assertEquals(OrientationEnum.E, mower.getOrientation());
        mowerAction.analyseAction(ActionEnum.D);
        assertEquals(OrientationEnum.S, mower.getOrientation());
        mowerAction.analyseAction(ActionEnum.D);
        assertEquals(OrientationEnum.W, mower.getOrientation());
        mowerAction.analyseAction(ActionEnum.D);
        assertEquals(OrientationEnum.N, mower.getOrientation());
    }

    @Test
    void analyseAction_if_action_is_A_with_0_0_orientation_S() {
        mower.setPositionAxisY(0);
        mower.setPositionAxisX(0);
        mower.setOrientation(OrientationEnum.S);
        mowerAction.analyseAction(ActionEnum.A);
        assertEquals(0, mower.getPositionAxisX());
        assertEquals(0, mower.getPositionAxisY());
    }

    @Test
    void analyseAction_if_action_is_A_with_0_0_orientation_W() {
        mower.setPositionAxisY(0);
        mower.setPositionAxisX(0);
        mower.setOrientation(OrientationEnum.W);
        mowerAction.analyseAction(ActionEnum.A);
        assertEquals(0, mower.getPositionAxisX());
        assertEquals(0, mower.getPositionAxisY());
    }

    @Test
    void analyseAction_if_action_is_A_with_0_0_orientation_N() {
        mower.setPositionAxisY(0);
        mower.setPositionAxisX(0);
        mower.setOrientation(OrientationEnum.N);
        mowerAction.analyseAction(ActionEnum.A);
        assertEquals(1, mower.getPositionAxisX());
        assertEquals(0, mower.getPositionAxisY());
    }

    @Test
    void analyseAction_if_action_is_A_with_0_0_orientation_E() {
        mower.setPositionAxisY(0);
        mower.setPositionAxisX(0);
        mower.setOrientation(OrientationEnum.E);
        mowerAction.analyseAction(ActionEnum.A);
        assertEquals(0, mower.getPositionAxisX());
        assertEquals(1, mower.getPositionAxisY());
    }

    @Test
    void analyseAction_if_action_is_A_with_5_5_orientation_S() {
        mower.setPositionAxisY(5);
        mower.setPositionAxisX(5);
        mower.setOrientation(OrientationEnum.S);
        mowerAction.analyseAction(ActionEnum.A);
        assertEquals(4, mower.getPositionAxisX());
        assertEquals(5, mower.getPositionAxisY());
    }

    @Test
    void analyseAction_if_action_is_A_with_5_5_orientation_W() {
        mower.setPositionAxisY(5);
        mower.setPositionAxisX(5);
        mower.setOrientation(OrientationEnum.S);
        mowerAction.analyseAction(ActionEnum.A);
        assertEquals(5, mower.getPositionAxisX());
        assertEquals(5, mower.getPositionAxisY());
    }

    @Test
    void analyseAction_if_action_is_A_with_5_5_orientation_E() {
        mower.setPositionAxisY(5);
        mower.setPositionAxisX(5);
        mower.setOrientation(OrientationEnum.S);
        mowerAction.analyseAction(ActionEnum.A);
        assertEquals(5, mower.getPositionAxisX());
        assertEquals(5, mower.getPositionAxisY());
    }

    @Test
    void analyseAction_if_action_is_A_with_5_5_orientation_N() {
        mower.setPositionAxisY(5);
        mower.setPositionAxisX(5);
        mower.setOrientation(OrientationEnum.N);
        mowerAction.analyseAction(ActionEnum.A);
        assertEquals(5, mower.getPositionAxisX());
        assertEquals(5, mower.getPositionAxisY());
    }
}