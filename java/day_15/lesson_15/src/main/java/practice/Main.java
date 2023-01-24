package practice;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Iphone 14 Pro max", 35_000_000, "Apple", 2));
        products.add(new Product(2, "OPPO Find x3 Pro", 9_000_000, "Opple", 1));
        products.add(new Product(3, "Iphone 13 ", 21_000_000, "Apple", 3));
        products.add(new Product(4, "Xiaomi 12", 15_000_000, "Xiaomi", 5));
        products.add(new Product(5, "Samsung Galaxy 20", 42_000_000, "Samsung", 4));
        products.add(new Product(6, "Samsung Z Fold 4", 22_000_000, "Samsung", 6));

        //1
        System.out.println("Danh sách sản phẩm là:");
        printInfo(products);
        //2
        System.out.println("Tổng tiền sản phẩm trong giỏ hàng là: ");
        System.out.println(getTotalProduct(products));
        //3
        System.out.println("Các sp của thương hiệu Apple la: ");
        printInfo(findByBrand(products,"Apple"));
        //4
        System.out.println("Các sản phẩm có giá >20tr là: ");
        printInfo(findByPrice(products));
        //5
        System.out.println("Các sản phẩm có chữ pro là: ");
        printInfo(findByName(products,"pro"));
        //6
        System.out.println("Thêm 1 sản phẩm vào danh sách");
        Product product = new Product(7,"Black Adam", 10_000_000,"Heros",8);
        addProduct(products,product);
        System.out.println(product);
        //7
        System.out.println("Xóa các sản phẩm có thương hiệu samsung");
        printInfo(deleteProduct(products,"Samsung"));
        //8
        System.out.println("Sắp xếp giỏ  hàng theo price tăng dần");
        printInfo(sortByPrice(products));
        //9
        System.out.println("Sắp xếp giỏ  hàng theo count giảm dần");
        printInfo(sortByCount(products));
        //10
        System.out.println("Ngẫu nhiên 2 sản phẩm");
        printInfo(getRandom(products));
    }

    //        In ra thông tin các sản phẩm trong giỏ hàng theo cấu trúc sau
//        ID - Tên - Giá - Thương Hiệu - Số lượng
//        Ví dụ : 1- OPPO Find X3 Pro - 19500000 - OPPO - 3
    public static void printInfo(List<Product> products) {
        products.forEach(product -> System.out.println(product.getId() + "-" + product.getName() + "-" + product.getPrice()
                + "-" + product.getBrand() + "-" + product.getCount()));
    }

    public static String formatMoney(long price){
            DecimalFormat formatter = new DecimalFormat("###,###,### VND");
            return formatter.format(price);
    }
//        Tính tổng tiền tất cả sản phẩm trong giỏ hàng

//        Tổng tiền mỗi sản phẩm = price * count
    public static  int getTotalProduct(List<Product> products){
        return products.stream()
                .map(product -> product.getCount()*product.getPrice())
                .mapToInt(Integer::valueOf).sum();
    }
//
//        Tìm các sản phẩm của thuơng hiệu “Apple”
    public static List<Product> findByBrand(List<Product> products,String brand){
        return  products.stream()
                .filter(product -> product.getBrand().equalsIgnoreCase(brand))
                .collect(Collectors.toList());
    }
//
//        Tìm các sản phẩm có giá > 20000000
    public static List<Product> findByPrice(List<Product> products){
        return products.stream()
                .filter(product -> product.getPrice()>20_000_000)
                .collect(Collectors.toList());
    }
//
//        Tìm các sản phẩm có chữ “pro” trong tên (Không phân biệt hoa thường)
    public static List<Product> findByName(List<Product> products, String name){
        return products.stream()
                .filter(product -> product.getName().toLowerCase().contains(name))
                .collect(Collectors.toList());
    }
//
//        Thêm 1 sản phẩm bất kỳ vào trong mảng product
    public static List<Product> addProduct(List<Product> products,Product product){
        products.add(product);
        return products;
    }
//
//        Xóa tất cả sản phẩm của thương hiệu “Samsung” trong giỏ hàng
    public static  List<Product> deleteProduct(List<Product> products,String brand){
        products.removeIf(a -> a.getBrand()==brand);
        return products;
    }
    //        Sắp xếp giỏ hàng theo price tăng dần
    public static  List<Product> sortByPrice(List<Product> products) {
        return products.stream().sorted((Comparator.comparingInt(Product::getPrice))).collect(Collectors.toList());
    }
    //        Sắp xếp giỏ hàng theo count giảm dần
    public static  List<Product> sortByCount(List<Product> products) {
        return products.stream().sorted(((o1, o2) -> o2.getCount()-o1.getCount())).collect(Collectors.toList());
    }
    //        Lấy ra 2 sản phẩm bất kỳ trong giỏ hàng
    public static List<Product> getRandom(List<Product> products){

         Collections.shuffle(products);
         return products.stream().limit(2).collect(Collectors.toList());

    }

//

//

//

}

