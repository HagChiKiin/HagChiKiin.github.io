package com.example.btvn.statics;

public enum Specialization {
    KHOA_HOC_TU_NHIEN("Khoa hoc tu nhien"),
    VAN_HOC_NGHE_THUAT("Van hoc nghe thuat"),
    DIEN_TU_VIEN_THONG("Dien tu vien thong"),
    CONG_NGHE_THONG_TIN("Cong nghe thong tin");


    public String name;


    Specialization(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
