package com.mowitnow.util;

public enum ActionEnum {
    A ("Forward"),
    G ("Turn to left"),
    D ("Turn to right");

    private String action;

    ActionEnum(String action) {
        this.action = action;
    }

    public static ActionEnum parse(char position) {
        for (ActionEnum e : ActionEnum.values()) {
            if (e.name().equals(Character.toString(position))) {
                return e;
            }
        }
        return null;
    }

    /**
     * Return true if action is different than A
     * @param action action instructed
     * @return
     */
    public static boolean isRotation(ActionEnum action) {
        return !action.equals(A);
    }

    /**
     * Return next position depending of actual position and action
     * @param orientation actual position
     * @param action action instructed
     * @return new position
     */
    public static OrientationEnum next(OrientationEnum orientation, ActionEnum action) {
        if (orientation.equals(OrientationEnum.N)) {
            if (action.equals(D)) return OrientationEnum.E;
            if (action.equals(G)) return OrientationEnum.W;
        } else if (orientation.equals(OrientationEnum.E)) {
            if (action.equals(D)) return OrientationEnum.S;
            if (action.equals(G)) return OrientationEnum.N;
        } else if (orientation.equals(OrientationEnum.S)) {
            if (action.equals(D)) return OrientationEnum.W;
            if (action.equals(G)) return OrientationEnum.E;
        }
        // if orientation is W
        if (action.equals(D)) return OrientationEnum.N;
        if (action.equals(G)) return OrientationEnum.S;

        // should never be called
        return null;
    }

    public String getAction() {
        return this.action;
    }
}
