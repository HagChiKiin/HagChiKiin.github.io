package book_management.frontend;

import book_management.backend.controller.BookController;
import book_management.backend.exception.NotFoundException;
import book_management.backend.model.Book;
import book_management.backend.request.CreateBookRequest;
import book_management.backend.request.UpdateBookRequest;

import java.util.*;

public class BookUI {
    private final BookController bookController = new BookController();

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
                    List<Book> books = bookController.getBooks();
                    if (books.isEmpty()) {
                        System.out.println("Không có quyển sách nào trong danh sách");
                    } else {
                        System.out.println("Danh sách book: ");
                        for (Book b : books
                        ) {
                            System.out.println(b);
                        }
                    }
                    break;
                }
                case 2: {
                    System.out.println("Nhập tên sách");
                    String name = sc.nextLine();
                    List<Book> books = bookController.getBooksByName(name);
                    if (books.isEmpty()) {
                        System.out.println("Không có quyển sách có tên là " + name);
                    } else {
                        System.out.println("Danh sách book có tên: " + name + " là:");
                        for (Book b : books
                        ) {
                            System.out.println(b);
                        }
                    }
                    break;
                }

                case 3: {
                    System.out.println("Nhập id cần xóa: ");
                    int id = Integer.parseInt(sc.nextLine());
                    try {
                        bookController.deleteBook(id);
                    } catch (NotFoundException e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                }


                case 4: {
                    System.out.println("Nhập vào id cần chỉnh sửa");
                    int id = Integer.parseInt(sc.nextLine());
                    System.out.println("Nhập vào tiêu đề:  ");
                    String title = sc.nextLine();
                    System.out.println("Nhập tên tác giả: ");
                    String author = sc.nextLine();
                    UpdateBookRequest request = new UpdateBookRequest(title, author);
                    try {
                        Book book = bookController.updateBook(id, request);
                        System.out.println("Thông tin sách sau khi cập nhật là: ");
                        System.out.println(book);

                    } catch (NotFoundException e) {
                        {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;


                }
                case 5:{
                    System.out.print("Nhập vào tiêu đề : ");
                    String title = sc.nextLine();

                    System.out.print("Nhập vào tên tác giả : ");
                    String author = sc.nextLine();

                    System.out.print("Nhập vào số trang sách : ");
                    int pageNumber = Integer.parseInt(sc.nextLine());

                    System.out.print("Nhập vào năm xuất bản : ");
                    int releaseYear = Integer.parseInt(sc.nextLine());

                    CreateBookRequest request = new CreateBookRequest(title, author, pageNumber, releaseYear);
                    Book book = bookController.createBook(request);

                    System.out.println("Quyển sách sau khi tạo là : ");
                    System.out.println(book);
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
        System.out.println("3 - In thông tin sản phẩm theo mức gia");
        System.out.println("4 - Thay đổi thông tin của book");
        System.out.println("5 - Tạo thêm sách mới");
        System.out.println("6 - Thoát");
    }
}

