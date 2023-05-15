package com.example.btvn.statics;

public enum Specialization {
    KHOA_HOC_TU_NHIEN(0,"Khoa hoc tu nhien"),
    VAN_HOC_NGHE_THUAT(1,"Van hoc nghe thuat"),
    DIEN_TU_VIEN_THONG(2,"Dien tu vien thong"),
    CONG_NGHE_THONG_TIN(3,"Cong nghe thong tin");

    public int id;
    public String name;

    Specialization(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
