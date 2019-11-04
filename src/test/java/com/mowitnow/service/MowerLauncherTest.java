package com.mowitnow.service;

import com.mowitnow.exception.MowItNowException;
import com.mowitnow.objects.Field;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MowerLauncherTest {

    private MowerLauncher mowerLauncher = new MowerLauncher();

    @Test
    void mowerInitialization_cant_create_if_not_in_field() {
        mowerLauncher.setField(new Field(5, 5));
        MowItNowException thrown = assertThrows(MowItNowException.class, () -> mowerLauncher.mowerInitialization("13 5 N", "ADDADAG"));
        assertTrue(thrown.getMessage().contains("Mower cannot be placed in the field : incorrect coordinates"));
    }

    @Test
    void mowerInitialization_cant_create_not_enough_info() {
        mowerLauncher.setField(new Field(5, 5));
        MowItNowException thrown = assertThrows(MowItNowException.class, () -> mowerLauncher.mowerInitialization("13 5", "ADDADAG"));
        assertTrue(thrown.getMessage().contains("Too much or too little input for mower initialization"));
    }

    @Test
    void mowerInitialization_cant_create_too_much_info() {
        mowerLauncher.setField(new Field(5, 5));
        MowItNowException thrown = assertThrows(MowItNowException.class, () -> mowerLauncher.mowerInitialization("13 5 N N", "ADDADAG"));
        assertTrue(thrown.getMessage().contains("Too much or too little input for mower initialization"));
    }

    @Test
    void mowerInitialization_cant_create_not_an_orientation() {
        mowerLauncher.setField(new Field(5, 5));
        MowItNowException thrown = assertThrows(MowItNowException.class, () -> mowerLauncher.mowerInitialization("5 5 D", "ADDADAG"));
        assertTrue(thrown.getMessage().contains("Orientation D does not exist"));
    }

    @Test
    void fieldInitialization_not_enough_info() {
        MowItNowException thrown = assertThrows(MowItNowException.class, () -> mowerLauncher.fieldInitialization("5"));
        assertTrue(thrown.getMessage().contains("Too much or too little input for field dimensions"));
    }

    @Test
    void fieldInitialization_too_much_info() {
        MowItNowException thrown = assertThrows(MowItNowException.class, () -> mowerLauncher.fieldInitialization("5 5 5"));
        assertTrue(thrown.getMessage().contains("Too much or too little input for field dimensions"));
    }

    @Test
    void parse_not_an_action() {
        MowItNowException thrown = assertThrows(MowItNowException.class, () -> mowerLauncher.parse("EADADGGDADAAA"));
        assertTrue(thrown.getMessage().contains("Element E is not a known action"));
    }

}