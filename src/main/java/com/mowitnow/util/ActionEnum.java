package com.mowitnow.util;

import java.util.ArrayList;
import java.util.List;

public enum ActionEnum {
    A ("Forward"),
    G ("Turn to left"),
    D ("Turn to right");

    String action;

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

    public String getAction() {
        return this.action;
    }
}
