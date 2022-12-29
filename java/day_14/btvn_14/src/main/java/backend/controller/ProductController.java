package backend.controller;

import backend.service.ProductService;

public class ProductController {
    private final ProductService productService = new ProductService();
    public void sortByCategory() {
         productService.sortByCategory();
    }

    public void sortByBrand() {
        productService.sortByBrand();
    }

    public void findByPrice() {
        productService.findByPrice();
    }
}
