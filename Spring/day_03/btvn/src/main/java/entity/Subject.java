package entity;


import statics.TypeOfSubject;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Subject implements InputInfo {
    private int id;
    private String name;
    private int credit;
    private TypeOfSubject type;
    private static int AUTO_ID = 100;

    public Subject() {
        this.id = AUTO_ID;
        AUTO_ID++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public TypeOfSubject getType() {
        return type;
    }

    public void setType(TypeOfSubject type) {
        this.type = type;
    }

    public static int getAutoId() {
        return AUTO_ID;
    }

    public static void setAutoId(int autoId) {
        AUTO_ID = autoId;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", credit=" + credit +
                ", type=" + type +
                '}';
    }

    @Override
    public void inputInfo() {
        System.out.println("Nhập vào tên môn học: ");
        this.setName(new Scanner(System.in).nextLine());

        System.out.println("Nhập vào số đơn vị học trình: ");
        this.setCredit(new Scanner(System.in).nextInt());

        System.out.println("Nhập loại môn học: ");
        System.out.println("1. Đại cương");
        System.out.println("2. Cơ sở ngành");
        System.out.println("3. Chuyên ngành");
        int choise;
        do {
            try {
                choise = new Scanner(System.in).nextInt();
                if (choise >= 1 && choise <= 3) {
                    break;
                }
                System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại: ");
            } catch (InputMismatchException ex) {
                System.out.println("Vui lòng chọn từ 1 đến 3");
            }
        } while (true);
        switch (choise) {
            case 1 -> this.setType(TypeOfSubject.DAI_CUONG);
            case 2 -> this.setType(TypeOfSubject.CO_SO_NGANH);
            case 3 -> this.setType(TypeOfSubject.CHUYEN_NGANH);
        }

    }
}


