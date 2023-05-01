package entity;

import statics.CustomerType;

import java.util.InputMismatchException;
import java.util.Scanner;



public class Customer extends Person{
    private int id;
    private CustomerType customerType;
    private static int AUTO_ID = 10000;

    public Customer() {
        this.id = AUTO_ID;
        AUTO_ID++;
    }

    public Customer(String name, String address, String phone) {
        super(name, address, phone);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public static int getAutoId() {
        return AUTO_ID;
    }

    public static void setAutoId(int autoId) {
        AUTO_ID = autoId;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", customerType=" + customerType +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    @Override
    public void inputInfo() {
        super.inputInfo();
        System.out.println("Nhập loại KH: ");
        System.out.println("1. Cá nhân");
        System.out.println("2. Đại diện đơn vị hành chính");
        System.out.println("3. Đại diện đơn vị kinh doanh");
        int choise ;
        do {
            try{
                choise  = new Scanner(System.in).nextInt();
                if(choise >=1 && choise <=3){
                    break;
                }
                System.out.println("lua chon khong hop le vui long nhap lai");
            }catch (InputMismatchException ex){
                System.out.println("vui long nhap so tu 1 den 4");
            }
        }
        while (true);
        switch (choise){
            case 1:
                this.setCustomerType(CustomerType.CA_NHAN);
                break;
            case 2:
                this.setCustomerType(CustomerType.HANH_CHINH);
                break;
            case 3:
                this.setCustomerType(CustomerType.KINH_DOANH);
                break;
            case 4:
                return;
        }
    }
}
