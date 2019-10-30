package com.mowitnow.data;

import com.mowitnow.exception.MowItNowException;

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
    public static OrientationEnum parse(String orientation) throws MowItNowException {
        for (OrientationEnum o : OrientationEnum.values()) {
            if (o.name().equals(orientation)) {
                return o;
            }
        }
        throw new MowItNowException("Orientation " + orientation + " does not exist");
    }
}
