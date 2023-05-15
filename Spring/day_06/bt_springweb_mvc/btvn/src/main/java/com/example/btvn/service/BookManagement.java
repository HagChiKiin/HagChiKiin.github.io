package com.example.btvn.service;

import com.example.btvn.entity.Book;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class BookManagement {
    private List<Book> books;

    public BookManagement() {
        this.books = new ArrayList<>();
    }
    public Book findById(int id){
        for (Book a : books) {
            if (a.getId() == id) {
                return a;
            }
        }
        return null;
    }
    public boolean isEmptyBook(){
        return this.books.isEmpty();
    }
    public void showBook(){
        books.forEach(System.out::println);
    }
    public void inputInfo() {
        System.out.println("Bạn muốn nhập cho bao nhiêu đầu sách: ");
        int bookNumber;
        do {
            try {
                bookNumber = new Scanner(System.in).nextInt();
                if (bookNumber > 0) {
                    break;
                }
                System.out.println("Số lượng đầu sách nhập vào phải lơn hơn 0, vui lòng nhập lại: ");
            } catch (InputMismatchException ex) {
                System.out.println("Vui lòng nhập số: ");
            }
        } while (true);

        for (int i = 0; i < bookNumber; i++) {
            Book book = new Book();
            book.inputInfo();
            books.add(book);
        }
        showBook();
    }
}
