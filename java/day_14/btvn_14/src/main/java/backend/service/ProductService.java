package backend.service;

import backend.model.Product;
import backend.repository.ProductRepo;

import java.util.ArrayList;

public class ProductService {
    private final ProductRepo productRepo = new ProductRepo();
    public void sortByCategory() {
       productRepo.sortByCategory();
    }

    public void sortByBrand() {
        productRepo.sorByBrand();
    }

    public void findByPrice(int price) {
        productRepo.findByPrice();
    }
}
