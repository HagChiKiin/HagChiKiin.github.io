package book_management.service;

import book_management.model.Book;
import book_management.repository.BookRepository;

// Chứa nghiệp vụ, nếu có tương tác với database sử dụng repository để lấy dữ liệu từ database
public class BookService {
    // Khởi tạo đối tượng bookRepository để có thể gọi phương thức của nó
    public BookRepository bookRepository = new BookRepository();

    // Tìm kiếm sách theo tiêu đề
    public void findByTitle(String title) {
        int count = 0;
        for (Book book: bookRepository.findAll()) {
            if(book.title.toLowerCase().contains(title.toLowerCase())) {
                System.out.println(book);
                count++;
            }
        }
        if(count == 0) {
            System.out.println("Không có quyền sách nào có title = " + title);
        }
    }
    // Tìm kiếm sách theo thể loại
    public void findByCategory(String category) {
        int count = 0;
        for (Book book: bookRepository.findAll()) {
            if(book.category.toLowerCase().contains(category.toLowerCase())) {
                System.out.println(book);
                count++;
            }
        }
        if(count == 0) {
            System.out.println("Không có quyền sách nào có thể loại = " + category);
        }
    }
    // Tìm kiếm các sách xuất bản trong năm
    public void publishBooks(int year) {
        for (Book book : bookRepository.findAll()) {
            if (book.year == year) {
                System.out.println(book);
            }
        }
    }
}