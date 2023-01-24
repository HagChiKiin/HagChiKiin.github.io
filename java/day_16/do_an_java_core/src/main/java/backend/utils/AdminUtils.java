package backend.utils;

import backend.model.Admin;
import backend.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class AdminUtils {
    public static ArrayList<Admin> getDataFromJsonFile(String fileName) {
        try {
            // Khởi tạo đối tượng gson
            Gson gson = new Gson();

            // Tạo đối tượng reader để đọc file
            Reader reader = Files.newBufferedReader(Paths.get(fileName));

            // Đọc thông tin từ file và binding và class
            Type type = new TypeToken<ArrayList<Admin>>() {
            }.getType();
            ArrayList<Admin> admins = gson.fromJson(reader, type);

            // Đọc file xong thì đóng lại
            // Và trả về kết quả
            reader.close();
            return admins;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }
    // Lưu dữ liệu lên file json
    public static void setDataToFile(String fileName, Object obj) {
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Writer writer = Files.newBufferedWriter(Paths.get(fileName));

            gson.toJson(obj, writer);

            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
