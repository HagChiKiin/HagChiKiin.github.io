package backend.database;

import backend.model.Product;
import backend.utils.FileUtils;

import java.util.ArrayList;
import java.util.List;

public class ProductDatabase {
    public static List<Product> products = FileUtils.getDataFromJsonFile("products.json");
}
