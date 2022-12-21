package repository;

import database.BookDatabase;
import model.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static model.FindJson.getListObjectFromJsonFile;

public class BookRepository {
    ArrayList<Book> books = BookDatabase.books;
    public static void findAll() {
        ArrayList<Book> books = getListObjectFromJsonFile("list-book.json");
        for (Book s :books
             ) {
            System.out.println(s);
        }
    }
    public ArrayList<Book> findByName(String name) {
        ArrayList<Book> rs = new ArrayList<>();
        for (Book e : BookDatabase.books) {
            if (e.getTitle().toLowerCase().contains(name.toLowerCase())) {
                rs.add(e);
            }
        }
        return rs;

    }
    public ArrayList<Book> findByCategory(String category) {
        ArrayList<Book> rs = new ArrayList<>();
        for (Book e : BookDatabase.books) {
            if (Arrays.toString(e.getCategory()).toLowerCase().contains(category.toLowerCase()))
            {
                rs.add(e);
            }
        }
        return rs;
    }
    public void sortByPageNumber(){
        ArrayList<Book> rs = (ArrayList<Book>) books.clone();
        rs.sort(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getPage_number() - o2.getPage_number();
            }
        });
        for (Book e :rs
             ) {
            System.out.println(e);
        }
    }
    public void sortByReleaseYear(){
        ArrayList<Book> rs = (ArrayList<Book>) books.clone();
        rs.sort(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getRelease_year() - o2.getRelease_year();
            }
        });
        for (Book e :rs
        ) {
            System.out.println(e);
        }
    }
}

