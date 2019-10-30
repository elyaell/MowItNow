package com.mowitnow;

import com.mowitnow.data.ActionEnum;
import com.mowitnow.data.OrientationEnum;
import com.mowitnow.objects.Field;
import com.mowitnow.objects.Mower;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class MowerActionTest {

    Mower mower;
    Field field;
    MowerAction mowerAction;

    @Before
    public void setUp() throws Exception {
        mower = new Mower(0, 0, OrientationEnum.N);
        field = new Field(5, 5);
        mowerAction = new MowerAction(mower, field);
    }

    @Test
    public void analyseAction_if_action_is_always_G() {
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
    public void analyseAction_if_action_is_always_D() {
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
    public void analyseAction_if_action_is_A_with_0_0_orientation_S() {
        mower.setPositionAxisY(0);
        mower.setPositionAxisX(0);
        mower.setOrientation(OrientationEnum.S);
        mowerAction.analyseAction(ActionEnum.A);
        assertEquals(0, mower.getPositionAxisX());
        assertEquals(0, mower.getPositionAxisY());
    }

    @Test
    public void analyseAction_if_action_is_A_with_0_0_orientation_W() {
        mower.setPositionAxisY(0);
        mower.setPositionAxisX(0);
        mower.setOrientation(OrientationEnum.W);
        mowerAction.analyseAction(ActionEnum.A);
        assertEquals(0, mower.getPositionAxisX());
        assertEquals(0, mower.getPositionAxisY());
    }

    @Test
    public void analyseAction_if_action_is_A_with_0_0_orientation_N() {
        mower.setPositionAxisY(0);
        mower.setPositionAxisX(0);
        mower.setOrientation(OrientationEnum.N);
        mowerAction.analyseAction(ActionEnum.A);
        assertEquals(0, mower.getPositionAxisX());
        assertEquals(1, mower.getPositionAxisY());
    }

    @Test
    public void analyseAction_if_action_is_A_with_0_0_orientation_E() {
        mower.setPositionAxisY(0);
        mower.setPositionAxisX(0);
        mower.setOrientation(OrientationEnum.E);
        mowerAction.analyseAction(ActionEnum.A);
        assertEquals(0, mower.getPositionAxisY());
        assertEquals(1, mower.getPositionAxisX());
    }

    @Test
    public void analyseAction_if_action_is_A_with_5_5_orientation_S() {
        mower.setPositionAxisY(5);
        mower.setPositionAxisX(5);
        mower.setOrientation(OrientationEnum.S);
        mowerAction.analyseAction(ActionEnum.A);
        assertEquals(5, mower.getPositionAxisX());
        assertEquals(4, mower.getPositionAxisY());
    }

    @Test
    public void analyseAction_if_action_is_A_with_5_5_orientation_W() {
        mower.setPositionAxisY(5);
        mower.setPositionAxisX(5);
        mower.setOrientation(OrientationEnum.W);
        mowerAction.analyseAction(ActionEnum.A);
        assertEquals(4, mower.getPositionAxisX());
        assertEquals(5, mower.getPositionAxisY());
    }

    @Test
    public void analyseAction_if_action_is_A_with_5_5_orientation_E() {
        mower.setPositionAxisY(5);
        mower.setPositionAxisX(5);
        mower.setOrientation(OrientationEnum.E);
        mowerAction.analyseAction(ActionEnum.A);
        assertEquals(5, mower.getPositionAxisX());
        assertEquals(5, mower.getPositionAxisY());
    }

    @Test
    public void analyseAction_if_action_is_A_with_5_5_orientation_N() {
        mower.setPositionAxisY(5);
        mower.setPositionAxisX(5);
        mower.setOrientation(OrientationEnum.N);
        mowerAction.analyseAction(ActionEnum.A);
        assertEquals(5, mower.getPositionAxisX());
        assertEquals(5, mower.getPositionAxisY());
    }

    @Test
    public void analyseAction_if_action_is_A_with_0_5_orientation_N() {
        mower.setPositionAxisY(5);
        mower.setPositionAxisX(0);
        mower.setOrientation(OrientationEnum.N);
        mowerAction.analyseAction(ActionEnum.A);
        assertEquals(5, mower.getPositionAxisY());
        assertEquals(0, mower.getPositionAxisX());
    }

    @Test
    public void analyseAction_if_action_is_A_with_0_5_orientation_S() {
        mower.setPositionAxisY(5);
        mower.setPositionAxisX(0);
        mower.setOrientation(OrientationEnum.S);
        mowerAction.analyseAction(ActionEnum.A);
        assertEquals(4, mower.getPositionAxisY());
        assertEquals(0, mower.getPositionAxisX());
    }

    @Test
    public void analyseAction_if_action_is_A_with_0_5_orientation_E() {
        mower.setPositionAxisY(5);
        mower.setPositionAxisX(0);
        mower.setOrientation(OrientationEnum.E);
        mowerAction.analyseAction(ActionEnum.A);
        assertEquals(5, mower.getPositionAxisY());
        assertEquals(1, mower.getPositionAxisX());
    }

    @Test
    public void analyseAction_if_action_is_A_with_0_5_orientation_W() {
        mower.setPositionAxisY(5);
        mower.setPositionAxisX(0);
        mower.setOrientation(OrientationEnum.W);
        mowerAction.analyseAction(ActionEnum.A);
        assertEquals(5, mower.getPositionAxisY());
        assertEquals(0, mower.getPositionAxisX());
    }


    @Test
    public void analyseAction_if_action_is_A_with_5_0_orientation_N() {
        mower.setPositionAxisX(5);
        mower.setPositionAxisY(0);
        mower.setOrientation(OrientationEnum.N);
        mowerAction.analyseAction(ActionEnum.A);
        assertEquals(5, mower.getPositionAxisX());
        assertEquals(1, mower.getPositionAxisY());
    }

    @Test
    public void analyseAction_if_action_is_A_with_5_0_orientation_S() {
        mower.setPositionAxisX(5);
        mower.setPositionAxisY(0);
        mower.setOrientation(OrientationEnum.S);
        mowerAction.analyseAction(ActionEnum.A);
        assertEquals(5, mower.getPositionAxisX());
        assertEquals(0, mower.getPositionAxisY());
    }

    @Test
    public void analyseAction_if_action_is_A_with_5_0_orientation_E() {
        mower.setPositionAxisX(5);
        mower.setPositionAxisY(0);
        mower.setOrientation(OrientationEnum.E);
        mowerAction.analyseAction(ActionEnum.A);
        assertEquals(5, mower.getPositionAxisX());
        assertEquals(0, mower.getPositionAxisY());
    }

    @Test
    public void analyseAction_if_action_is_A_with_5_0_orientation_W() {
        mower.setPositionAxisX(5);
        mower.setPositionAxisY(0);
        mower.setOrientation(OrientationEnum.W);
        mowerAction.analyseAction(ActionEnum.A);
        assertEquals(4, mower.getPositionAxisX());
        assertEquals(0, mower.getPositionAxisY());
    }
}