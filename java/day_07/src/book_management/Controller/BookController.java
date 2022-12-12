package book_management.controller;

import book_management.service.BookService;
import java.time.LocalDate;
import java.util.Scanner;

// Lấy thông tin người dùng tương tác với hệ thống --> gọi các hàm sử lý tương ứng ở trong service
public class BookController {
    public BookService bookService = new BookService();

    public void run() {
        Scanner sc = new Scanner(System.in);
        int option = 0;
        boolean isQuit = false;
        while (!isQuit) {
            showMenu();
            System.out.print("Nhập lựa chọn : ");
            option = Integer.parseInt(sc.nextLine());

            switch (option) {
                case 1: {
                    System.out.print("Nhập tiêu đề book cần tìm : ");
                    String title = sc.nextLine();
                    bookService.findByTitle(title);
                    break;
                }
                case 2: {
                    System.out.print("Nhập thể loại sách cần tìm : ");
                    String category = sc.nextLine();
                    bookService.findByCategory(category);
                    break;
                }
                case 3: {
                    System.out.print("Các sách xuất bản trong năm nay là : \n");
                    LocalDate localDate = LocalDate.now();
                    int year = localDate.getYear();
                    bookService.publishBooks(year);

                    break;
                }
                case 4: {
                    isQuit = true;
                    System.out.println("^.^ GoodBye ^.^");
                    break;
                }
                default: {
                    System.out.println("Lựa chọn không hợp lệ");
                    break;
                }
            }
        }
    }

    public static void showMenu() {
        System.out.println("\n********* MENU *********");
        System.out.println("1 - Tìm kiếm book theo tên");
        System.out.println("2 - Tìm kiếm book theo thể loại");
        System.out.println("3 - Liệt kê các danh sách xuất bản năm nay");
        System.out.println("4 - Thoát\n");
    }
}