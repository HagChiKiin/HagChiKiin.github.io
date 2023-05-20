package com.example.btvn.statics;

public enum Status {
    NEW("Mới"), LIKE_NEW("Gần mới"), VERY_GOOD("Rất tốt"), GOOD("tốt"), ACCEPTABLE("dùng được");

    String name;

    Status(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
