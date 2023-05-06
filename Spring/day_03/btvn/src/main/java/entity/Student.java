package entity;


import java.util.Scanner;

public class Student extends Person {

    private int id;
    private String classRoom;

    private static int AUTO_ID = 10000;

    public Student() {
        this.id = AUTO_ID;
        AUTO_ID++;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }

    public static int getAutoId() {
        return AUTO_ID;
    }

    public static void setAutoId(int autoId) {
        AUTO_ID = autoId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", id=" + id +
                ", classRoom='" + classRoom + '\'' +
                '}';
    }

    @Override
    public void inputInfo() {
        super.inputInfo();
        System.out.println("Nhập vào lớp: ");
        this.setClassRoom(new Scanner(System.in).nextLine());
    }
}


