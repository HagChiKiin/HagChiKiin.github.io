package controller;


import service.StoreService;

import java.util.Scanner;

public class StoreController {
    public StoreService storeService = new StoreService();
    public  void run(){
        Scanner sc = new Scanner(System.in);
        int option = 0 ;
        boolean isQuit = false;
        while (!isQuit){
            showMenu();
            System.out.println("Nhập lựa chọn : ");
            option = Integer.parseInt(sc.nextLine());
            switch (option){
                case 1:{
                    System.out.println("Danh sách sản phẩm là: ");
                    storeService.seelist();
                    break;
                }

                case 2:{
                    System.out.print("Nhập tên cần tìm : ");
                    String name = sc.nextLine();
                    storeService.findName(name);
                    break;
                }
                case 3:{
                    System.out.println("Nhập id cần tìm: ");
                    int id = Integer.parseInt(sc.nextLine());
                    storeService.findId(id);
                    break;
                }
                case 4:{
                    System.out.println("Sản phẩm có số lượng dưới 5 là ");
                    storeService.findQuality();
                    break;
                }
                case 5:{
                    storeService.findPrice();
                    break;
                }

                case 6:{
                    isQuit =  true;
                    System.out.println("Good bye");
                    break;
                }
                default: {
                    System.out.println("Lựa chọn không hợp lệ");
                    break;
                }
            }

        }

    }
    public static void showMenu(){
        System.out.println("\n********* MENU *********");
        System.out.println("1 - Xem danh sách sản phẩm");
        System.out.println("2 - Tm sản phẩm theo tên");
        System.out.println("3 - Tìm sản phẩm theo id");
        System.out.println("4 - Tìm sản phẩm có số lượng dưới 5");
        System.out.println("5 - Tìm sản phẩm theo mức giá");
        System.out.println("6 - Thoát\n");
    }
}
