package model;

import com.google.gson.Gson;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class FindJson {
    public static void main(String[] args) {
        List<Book> books = getListObjectFromJsonFile("list-book.json");
        System.out.println("Đọc thông tin từ file Json");
        for (Book s : books
        ) {
            System.out.println(s);
        }
    }
    public static List<Book> getListObjectFromJsonFile(String fileName) {
        try {
            // Khởi tạo đối tượng gson
            Gson gson = new Gson();

            // Tạo đối tượng reader để đọc file
            Reader reader = Files.newBufferedReader(Paths.get(fileName));

            // Đọc thông tin từ file và binding và class
            List<Book> bookss = Arrays.asList(gson.fromJson(reader, Book[].class));

            // Đọc file xong thì đóng lại
            // Và trả về kết quả
            reader.close();
            return bookss;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}

