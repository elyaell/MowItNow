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

    /**
     * Transform the string with the orientation in the OrientationEnum type
     * @param orientation the orientation
     * @return {@link OrientationEnum}
     */
    public static OrientationEnum parse(String orientation) {
        for (OrientationEnum o : OrientationEnum.values()) {
            if (o.name().equals(orientation)) {
                return o;
            }
        }
        return null;
    }
}
