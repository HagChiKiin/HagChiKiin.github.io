package com.example.btvn.statics;

public enum ReaderType {
    SINH_VIEN(0,"Sinh vien"),
    HOCVIEN_CAOHOC(1, "Hoc vien cao hoc"),
    GIANG_VIEN(2, "Giang vien");

    public int id;
    public String name;

    ReaderType(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
