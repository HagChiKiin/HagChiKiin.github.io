package backend.repository;

import backend.database.ProductDatabase;
import backend.model.Product;

import java.util.*;

public class ProductRepo {

    public void sortByCategory() {
        List<Product> products = ProductDatabase.products;
        Collections.sort(products, Comparator.comparing(o -> Arrays.toString(o.getCategory())));
        for (Product p : products
        ) {
            System.out.println(p);

        }
    }

    public void sorByBrand() {
        List<Product> products = ProductDatabase.products;
        Collections.sort(products, (o1, o2) -> o1.getFirm().compareTo(o2.getFirm()) + o1.getQuanlity() - o2.getQuanlity());


        for (Product p : products
        ) {
            System.out.println(p);

        }
    }

    public void findByPrice( int price) {
        List<Product> products = ProductDatabase.products;
        for (Product p : products
        ) {
            if (price < 2_000_000) {
                System.out.println(p);
            } else if (price >= 2_000_000 && price < 4_000_000) {
                System.out.println(p);
            } else if (price >= 4_000_000 && price < 7_000_000) {
                System.out.println(p);
            } else if (price >= 7_000_000 && price < 13_000_000) {
                System.out.println(p);
            } else {
                System.out.println(p);
            }
        }
    }
}

