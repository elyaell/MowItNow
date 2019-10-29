package com.mowitnow.objects;

import java.util.Arrays;

public class Field {

    Integer[][] field;

    public Field(int length, int width) {
        field = new Integer[length][width];
    }

    @Override
    public String toString() {
        return "Field {" +
                "length = " + field.length +
                ", width = " + field[0].length +
                '}';
    }
}
