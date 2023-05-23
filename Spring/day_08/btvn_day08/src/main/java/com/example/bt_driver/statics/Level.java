package com.example.bt_driver.statics;

public enum Level {
    A("Loại A"),
    B("Loại B"),
    C("Loại C"),
    D("Loại D"),
    E("Loại E"),
    F("Loại F");

    public String name;

    Level(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
