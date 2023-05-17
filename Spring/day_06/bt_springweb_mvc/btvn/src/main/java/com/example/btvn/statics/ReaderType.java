package com.example.btvn.statics;

public enum ReaderType {
    SINH_VIEN("Sinh vien"),
    HOCVIEN_CAOHOC("Hoc vien cao hoc"),
    GIANG_VIEN( "Giang vien");

    public String name;

    ReaderType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
