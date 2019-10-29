package com.mowitnow.util;

public enum ActionEnum {
    A ("Forward"),
    G ("Turn to left"),
    D ("Turn to right");

    String action;

    ActionEnum(String action) {
        this.action = action;
    }

    public String getAction() {
        return this.action;
    }
}
