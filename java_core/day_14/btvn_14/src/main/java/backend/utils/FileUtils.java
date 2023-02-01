package backend.utils;

import backend.model.Product;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.PrimitiveIterator;

public class FileUtils {
    public static ArrayList<Product> getDataFromJsonFile(String fileName) {
        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get(fileName));

            Type type = new TypeToken<ArrayList<Product>>() {
            }.getType();
            ArrayList<Product> pro = gson.fromJson(reader, type);
            reader.close();
            return pro;
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return new ArrayList<>();
    }

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
