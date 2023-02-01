package frontend;

import backend.controller.ProductController;
import backend.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductUI {
    private final ProductController productController = new ProductController();
    public void run() {
        Scanner sc = new Scanner(System.in);
        int option = 0;
        boolean isQuit = false;

        while (!isQuit) {
            showMenu();
            try{
                System.out.println("Nhập lựa chọn: ");
                option = Integer.parseInt(sc.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Nhập số đi bạn");
                continue;
            }
            switch (option) {
                case 1: {
                    productController.sortByCategory();
                    break;
                }
                case 2: {
                    productController.sortByBrand();
                    break;
                }

                case 3: {
                    productController.findByPrice();

                    break;
                }


                case 4: {
                    productController.findByName();
                    break;


                }
                case 5:{
                    break;
                }

                case 6:
                    isQuit = true;
                    break;
                default: {
                    System.out.println("Lựa chọn không hợp lệ");
                }
            }
        }
    }

    public void showMenu() {
        System.out.println("\n------------MENU------------");
        System.out.println("1 - In thông tin sản phẩm theo danh mục");
        System.out.println("2 - In thông tin sản phẩm theo hãng và số sản phẩm");
        System.out.println("3 - In thông tin sản phẩm theo mức giá và danh mục");
        System.out.println("4 - Tìm sản phẩm theo tên và số sản phẩm");
        System.out.println("5 - Liệt kê các hãng và số lượng sản phẩm của mỗi hãng");
        System.out.println("6 - Thoát");
    }
}
