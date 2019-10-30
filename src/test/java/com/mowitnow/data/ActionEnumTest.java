package com.mowitnow.data;

import com.mowitnow.exception.MowItNowException;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ActionEnumTest {

    @Test
    void parse() {
        Throwable thrown = assertThrows(MowItNowException.class, () -> ActionEnum.parse('E'));
        assertThat(thrown.getMessage(), is("Element E is not a known action"));
    }

    @Test
    void isRotation() {
        boolean result = ActionEnum.isRotation(ActionEnum.A);
        assertFalse(result);

        result = ActionEnum.isRotation(ActionEnum.D);
        assertTrue(result);

        result = ActionEnum.isRotation(ActionEnum.G);
        assertTrue(result);
    }

    @Test
    void next() {
        OrientationEnum direction = ActionEnum.next(OrientationEnum.S, ActionEnum.A);
        assertNull(direction);

        direction = ActionEnum.next(OrientationEnum.S, ActionEnum.D);
        assertEquals(OrientationEnum.W, direction);

        direction = ActionEnum.next(OrientationEnum.S, ActionEnum.G);
        assertEquals(OrientationEnum.E, direction);

        direction = ActionEnum.next(OrientationEnum.E, ActionEnum.D);
        assertEquals(OrientationEnum.S, direction);

        direction = ActionEnum.next(OrientationEnum.E, ActionEnum.G);
        assertEquals(OrientationEnum.N, direction);

        direction = ActionEnum.next(OrientationEnum.W, ActionEnum.D);
        assertEquals(OrientationEnum.N, direction);

        direction = ActionEnum.next(OrientationEnum.W, ActionEnum.G);
        assertEquals(OrientationEnum.S, direction);

        direction = ActionEnum.next(OrientationEnum.N, ActionEnum.D);
        assertEquals(OrientationEnum.E, direction);

        direction = ActionEnum.next(OrientationEnum.N, ActionEnum.G);
        assertEquals(OrientationEnum.W, direction);
    }
}