package program.backend.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import program.backend.model.Account;

import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileUtils {

    public static ArrayList<Account> getDataFromJsonFile(String fileName) {
        try {
            Gson gson = new Gson();

            Reader reader = Files.newBufferedReader(Paths.get(fileName));

            Type type = new TypeToken<ArrayList<Account >>(){}.getType();
            ArrayList<Account> accounts = gson.fromJson(reader, type);

            reader.close();
            return accounts;
        } catch (Exception e) {
            e.printStackTrace();
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
