package com.mowitnow.data;

public enum OrientationEnum {
    N ("North"),
    S ("South"),
    E ("East"),
    W ("West");

    private String orientation;

    OrientationEnum(String orientation) {
        this.orientation = orientation;
    }

    public String getOrientation() {
        return this.orientation;
    }

    public static OrientationEnum parse(String orientation) {
        for (OrientationEnum o : OrientationEnum.values()) {
            if (o.name().equals(orientation)) {
                return o;
            }
        }
        return null;
    }
}
