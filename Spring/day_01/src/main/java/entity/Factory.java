package entity;

import java.util.Scanner;

public class Factory implements InputInfo{
    private int id;
    private String name;
    private String description;
    private float productivity;
    private static int AUTO_ID =100;

    public Factory() {
        this.id=AUTO_ID;
        AUTO_ID++;
    }

    @Override
    public void inputInfo() {
        System.out.println("nhap ten xuong: ");
        this.setName(new Scanner(System.in).nextLine());

        System.out.println("nhap mo ta: ");
        this.setDescription(new Scanner(System.in).nextLine());

        System.out.println("nhap he so cong viec: ");
        this.setProductivity(new Scanner(System.in).nextFloat());

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getProductivity() {
        return productivity;
    }

    public void setProductivity(float productivity) {
        this.productivity = productivity;
    }

    @Override
    public String toString() {
        return "Factory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", productivity=" + productivity +
                '}';
    }
}
