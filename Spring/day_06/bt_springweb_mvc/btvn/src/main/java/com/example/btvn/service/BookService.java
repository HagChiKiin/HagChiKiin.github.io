package com.example.btvn.service;

import com.example.btvn.entity.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class BookService {
    private final List<Book> books = new ArrayList<>();

    public List<Book> getAlBook() {
        return books;
    }
    public void saveBook(Book book) {
        book.setId(books.size());
        books.add(book);
    }

    public void delete(int id) {
        books.removeIf(a->a.getId() == id);
    }

    public Book findById(int id) {
        for (Book b: books) {
            if(b.getId() == id){
                return b;
            }
        }
        return null;
    }

    public void updateBook(Book book) {
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
