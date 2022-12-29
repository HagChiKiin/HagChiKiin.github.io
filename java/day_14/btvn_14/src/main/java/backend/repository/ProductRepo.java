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

    public void findByPrice() {
        List<Product> products = ProductDatabase.products;
        Collections.sort(products, (o1, o2) -> Arrays.toString(o1.getCategory()).compareTo(Arrays.toString(o2.getCategory()))+
                o1.getPrice()-o2.getPrice());

        for (Product p : products
        ) {
            if (p.getPrice() < 2_000_000) {
                System.out.println("Danh sách sản phẩm có giá dưới 2tr là: ");
                System.out.println(p);
            } else if (p.getPrice() >= 2_000_000 && p.getPrice() < 4_000_000) {
                System.out.println("Danh sách sản phẩm có giá từ 2tr đến 4tr là: ");
                System.out.println(p);
            } else if (p.getPrice() >= 4_000_000 && p.getPrice() < 7_000_000) {
                System.out.println("Danh sách sản phẩm có giá từ 4tr đến 7tr là: ");
                System.out.println(p);
            } else if (p.getPrice() >= 7_000_000 && p.getPrice() < 13_000_000) {
                System.out.println("Danh sách sản phẩm có giá từ 7tr đến 13tr là: ");
                System.out.println(p);
            } else {
                System.out.println("Danh sách sản phẩm có giá trên 13tr là: ");
                System.out.println(p);
            }
        }
    }
    public void findByName(){
        List<Product> products = ProductDatabase.products;
        Collections.sort(products, (o1, o2) -> o1.getName().compareTo(o2.getName())+ o1.getQuanlity()-o2.getQuanlity());
        for (Product p :products
             ) {
            System.out.println(p);
        }
    }
}

