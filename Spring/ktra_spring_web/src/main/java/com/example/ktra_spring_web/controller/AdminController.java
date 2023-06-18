package com.example.ktra_spring_web.controller;

import com.example.ktra_spring_web.entity.Product;
import com.example.ktra_spring_web.exception.NotFoundException;
import com.example.ktra_spring_web.model.request.AppointmentRequest;
import com.example.ktra_spring_web.model.request.ProductRequest;
import com.example.ktra_spring_web.model.response.AppointmentResponse;
import com.example.ktra_spring_web.model.response.ProductResponse;
import com.example.ktra_spring_web.service.AppointmentService;
import com.example.ktra_spring_web.service.ProductService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AdminController {

    ProductService productService;

    AppointmentService appointmentService;

    @GetMapping("/admin")
    public String adminPage(Model model) {
        model.addAttribute("products", productService.getAllProduct());

        return "admin";
    }

    @GetMapping("/products")
    public String adminPage1(Model model) {
        List<Product> products = productService.getAllProduct();
        model.addAttribute("danhSachProduct", products);
        model.addAttribute("productTaoMoi",new ProductRequest());

        return "product";
    }

    // thêm
    @PostMapping("/api/v1/products")
    public ResponseEntity<?> createProduct(@RequestBody @Valid ProductRequest productRequest) {
        ProductResponse productResponse = productService.saveProduct(productRequest);
        return ResponseEntity.ok(productResponse);
    }
    //sửa
    @PutMapping("/api/v1/products/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Integer id, @RequestBody @Valid ProductRequest productRequest) throws NotFoundException {
        ProductResponse productResponse = productService.updateProduct(id, productRequest);
        return ResponseEntity.ok(productResponse);
    }
//    // xóa
//    @DeleteMapping("/api/v1/products/{id}")
//    public ResponseEntity<?> deleteProduct(@PathVariable Integer id) {
//        productService.deleteProduct(id);
//        return ResponseEntity.noContent().build();
//    }

    // Xem danh sách lịch hẹn khám
    @GetMapping("/appointments")
    public String appointment(Model model) {
        model.addAttribute("appointments", productService.getAllAppointment());
        return "appointment";
    }

     @PutMapping("/api/v1/appointments/{id}")
    public ResponseEntity<?> updateAppointment(@PathVariable Integer id, @RequestBody AppointmentRequest appointmentRequest) throws NotFoundException {
        AppointmentResponse appointmentResponse = appointmentService.updateAppointment(id, appointmentRequest);
        return ResponseEntity.ok(appointmentResponse);
    }
}