package controller;

import model.Book;
import model.FindJson;
import repository.BookRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static model.FindJson.getListObjectFromJsonFile;

public class BookController {
    BookRepository bookRepository = new BookRepository();
    public void run() {
        Scanner sc = new Scanner(System.in);
        boolean isQuit = false;

        while (!isQuit) {
            showMenu();
            System.out.print("Nhập lựa chọn : ");
            int option = Integer.parseInt(sc.nextLine());

            switch (option) {
                case 1: {
                    bookRepository.findAll();
                }
                    break;
                case 2:
                    System.out.println("Nhập tên cần tìm: ");
                    String title = sc.nextLine();
                    ArrayList<Book> books = bookRepository.findByName(title);
                    System.out.println(books);
                    break;
                case 3:
                    System.out.println("Nhập thể loại cần tìm: ");
                    String category = sc.nextLine();
                    ArrayList<Book> books1 = bookRepository.findByCategory(category);
                    System.out.println(books1);

                    break;
                case 4:
                    bookRepository.sortByPageNumber();
                    break;
                case 5:
                    bookRepository.sortByReleaseYear();
                    break;
                case 6:
                    isQuit = true;
                    break;
                default:{
                    System.out.println("Lựa chọn không hợp lệ");
                }
            }
        }
    }

    public void showMenu() {
        System.out.println("\n------------MENU------------");
        System.out.println(
                        "1. Lấy thông tin toàn bộ sách\n" +
                        "2. Tìm sách theo tên\n" +
                        "3. Tìm sách theo thể loại\n" +
                        "4. Sắp xếp sách theo số trang\n" +
                        "5. Sắp xếp sách theo năm xuất bản\n" +
                        "6. Thoát");
    }
}
