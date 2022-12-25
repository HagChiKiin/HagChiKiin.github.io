package book_management;

import book_management.backend.database.BookDatabase;
import book_management.backend.model.Book;
import book_management.frontend.BookUI;

public class Main {
    public static void main(String[] args) {
        BookUI bookUI = new BookUI();
        bookUI.run();
    }
}
