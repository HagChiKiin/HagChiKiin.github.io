package book_management.backend.service;

import book_management.backend.model.Book;
import book_management.backend.repository.BookRepository;
import book_management.backend.request.CreateBookRequest;
import book_management.backend.request.UpdateBookRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BookService {
    private final BookRepository bookRepository = new BookRepository();
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public List<Book> getBooksByName(String name) {
            List<Book> books = bookRepository.findAll();
            List<Book> rs = new ArrayList<>();
        for (Book b :books
             ) {
            if(b.getTitle().toLowerCase().contains(name.toLowerCase()));
            rs.add(b);
        }
        return rs;
    }
    public void deleteBook(int id){
        // Không có sách -> Thì báo lỗi
        Book book = bookRepository.findById(id);

        // Có sách -> Xóa
        bookRepository.delete(book);

    }

    public Book updateBook(int id, UpdateBookRequest request) {
       return bookRepository.update(id,request);
    }

    public Book createBook(CreateBookRequest request) {
        Random rd = new Random();
        Book book = new Book();
        book.setId(rd.nextInt(1000));
        book.setTitle(request.getTitle());
        book.setCategories(request.getCategories());
        book.setAuthor(request.getAuthor());
        book.setPageNumber(request.getPageNumber());
        book.setReleaseYear(request.getReleaseYear());
        bookRepository.save(book);
        return book;
    }
}
