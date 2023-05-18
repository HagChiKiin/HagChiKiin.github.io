package com.example.btvn.service;

import com.example.btvn.entity.Book;
import com.example.btvn.model.BookModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BookService {

    ObjectMapper objectMapper;
    List<Book> books = new ArrayList<>();
    private static int AUTO_ID = 1;


    public List<BookModel> getAlBook() {
        List<BookModel> result = new ArrayList<>();
        for (Book b : books) {
            BookModel bookModel = objectMapper.convertValue(b, BookModel.class);
            result.add(bookModel);
        }
        return result;
    }
    public void saveBook(BookModel book) {
        Book book1 = objectMapper.convertValue(book, Book.class);
        book1.setId(AUTO_ID);
        books.add(book1);
        AUTO_ID++;

    }

    public void delete(int id) {
        books.removeIf(a->a.getId() == id);
    }

    public BookModel findById(int id) {
        Optional<Book> bookOptional = books
                .stream()
                .filter(s->s.getId() == id)
                .findFirst();  // lay thang dau tien
        if(bookOptional.isEmpty()){
            return null;
        }
        Book book = bookOptional.get();
        return objectMapper.convertValue(book, BookModel.class);

    }

    public void updateBook(BookModel book) {
        books.forEach(s->{
            if(s.getId() != book.getId()){
                return;
            }
            s.setId(book.getId());
            s.setName(book.getName());
            s.setAuthor(book.getAuthor());
            s.setPublishedYear(book.getPublishedYear());
            s.setSpecialization(book.getSpecialization());
        });
    }
}
