package entity;


import java.util.Scanner;

public class Person implements InputInfo {
     protected String name;
    protected String address;
    protected String  phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public Person(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public Person() {
    }

    @Override
    public void inputInfo(){
        System.out.println("Nhap ho ten: ");
        this.setName(new Scanner(System.in).nextLine());

        System.out.println("Nhap dia chi: ");
        this.setAddress(new Scanner(System.in).nextLine());

        System.out.println("Nhap sdt: ");
        this.setPhone(new Scanner(System.in).nextLine());
    }
}
