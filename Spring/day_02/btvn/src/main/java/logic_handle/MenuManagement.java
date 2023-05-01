package logic_handle;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuManagement {
    private CustomerManagement customerManagement;
    private ServiceManagement serviceManagement;
    private BillManagement billManagement;

    public MenuManagement() {
        this.customerManagement = new CustomerManagement();
        this.serviceManagement = new ServiceManagement();
        this.billManagement = new BillManagement(customerManagement, serviceManagement);
    }

    public void menu() {
        while (true) {
            printMenu();
            int functionChoise = functionChoise();
            switch (functionChoise) {
                case 1:
                    customerManagement.inputInfo();
                    break;
                case 2:
                    serviceManagement.inputInfo();
                    break;
                case 3:
                    billManagement.bill();
                    break;
                case 4:
                    boolean isQuit1 = false;
                    int choise1 = 0;
                    while (!isQuit1) {
                        printMenu4();
                        try {
                            choise1 = new Scanner(System.in).nextInt();
                            if (choise1 >= 1 && choise1 <= 2) {
                                break;
                            }
                            System.out.println("lua chon khong hop le vui long nhap lai");
                        } catch (InputMismatchException ex) {
                            System.out.println("vui long nhap so tu 1 den 2");
                        }
                        switch (choise1) {
                            case 1: {
                                billManagement.sortByName();
                                break;
                            }
                            case 2: {
                                billManagement.sort();
                            }
                            case 3:{
                                isQuit1 = true;
                                System.out.println("Quay về menu");
                                break;
                            }

                        }
                    }
                case 5:
                    billManagement.sortByName();
                    break;
                case 6:
                    return;
            }
        }
    }



    private void printMenu() {
        System.out.println("------------PHẦN MỀM QUẢN LÝ HÓA ĐƠN KHÁCH HÀNG-----------------");
        System.out.println("1. Nhap danh sach khach hang va in ra man hinh");
        System.out.println("2. Nhap danh sach dich vu va in ra man hinh");
        System.out.println("3. Nhap hoa don cho moi khach hang va in ra man hinh");
        System.out.println("4. Sap xep danh sach hoa don");
        System.out.println("5. lap bang ke so tien phai tra cho moi khach hang");
        System.out.println("6. Thoat");
        System.out.println("Xin moi chon chuc nang");
        System.out.println("-------------------------------");
    }

    private void printMenu4() {
        System.out.println("1. Sắp xếp theo họ tên khách hàng");
        System.out.println("2. Sắp xếp theo số lượng sử dụng giảm dần");
        System.out.println("3. Quay trở lại ");
    }

    private int functionChoise() {
        int choise;
        do {
            try {
                choise = new Scanner(System.in).nextInt();
                if (choise >= 1 && choise <= 6) {
                    break;
                }
                System.out.println("lua chon khong hop le vui long nhap lai");
            } catch (InputMismatchException ex) {
                System.out.println("vui long nhap so tu 1 den 6");
            }
        }
        while (true);
        return choise;
    }
}
