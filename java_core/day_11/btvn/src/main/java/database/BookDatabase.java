package database;

import model.Book;

import java.util.ArrayList;
import java.util.List;

import static model.FindJson.getListObjectFromJsonFile;

public class BookDatabase {
    public static ArrayList<Book> books = getListObjectFromJsonFile("list-book.json");
}

