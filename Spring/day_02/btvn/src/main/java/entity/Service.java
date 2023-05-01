package entity;



import java.util.Scanner;



public class Service implements InputInfo {
    private int id;
    private String name;
    private int price;
    private String unit;
    private static int AUTO_ID = 100;

    public Service() {
        this.id = AUTO_ID;
        AUTO_ID++;
    }

    public Service(int id, String name, int price, String unit) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.unit = unit;
    }


    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", unit='" + unit + '\'' +
                '}';
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public static int getAutoId() {
        return AUTO_ID;
    }

    public static void setAutoId(int autoId) {
        AUTO_ID = autoId;
    }

    @Override
    public void inputInfo() {
        System.out.println("nhap ten dich vu: ");
        this.setName(new Scanner(System.in).nextLine());

        System.out.println("nhap gia cuoc: ");
        this.setPrice(new Scanner(System.in).nextInt());

        System.out.println("nhap don vi tinh: ");
        this.setUnit(new Scanner(System.in).nextLine());

    }
}
