package book_management.backend.database;

import book_management.backend.model.Book;
import book_management.backend.utils.FileUtils;

import java.util.List;

public class BookDatabase {
    public static List<Book> books = FileUtils.getDataFromJsonFile("book.json");
    // bên trai gán dữ lieuj database thì bên phải phải là array list
}
