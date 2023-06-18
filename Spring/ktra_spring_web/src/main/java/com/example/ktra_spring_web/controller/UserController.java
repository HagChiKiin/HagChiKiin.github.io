package com.example.ktra_spring_web.controller;

import com.example.ktra_spring_web.entity.Appointment;
import com.example.ktra_spring_web.entity.Product;
import com.example.ktra_spring_web.exception.NotFoundException;
import com.example.ktra_spring_web.model.request.AppointmentRequest;
import com.example.ktra_spring_web.model.request.OrderRequest;
import com.example.ktra_spring_web.model.response.AppointmentResponse;
import com.example.ktra_spring_web.model.response.ProductResponse;
import com.example.ktra_spring_web.service.AppointmentService;
import com.example.ktra_spring_web.service.EmailService;
import com.example.ktra_spring_web.service.OrderService;
import com.example.ktra_spring_web.service.ProductService;
import com.example.ktra_spring_web.statics.Status;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {

    ProductService productService;

    AppointmentService appointmentService;

    OrderService orderService;

    EmailService emailService;



    @GetMapping("/index")
    public String homePage(Model model) {
        model.addAttribute("products", productService.getAllProduct());
        return "index";
    }

    @RequestMapping("/about")
    public String aboutPage(Model model) {
        return "about";
    }

    @RequestMapping("/contact")
    public String contactPage(Model model) {
        return "contact";
    }

    // Tạo appointment
    @PostMapping("/api/v1/appointment")
    public ResponseEntity<?> createAppointment(@RequestBody @Valid AppointmentRequest appointmentRequest) {
        AppointmentResponse appointmentResponse = appointmentService.createAppointment(appointmentRequest);
        return new ResponseEntity<>(appointmentResponse, HttpStatus.CREATED);
    }

    // Tạo order
    @PostMapping("/api/v1/order/{productId}")
    public ResponseEntity<?> createOrder(@PathVariable Integer productId, @RequestBody @Valid OrderRequest orderRequest) throws NotFoundException {
        orderService.createOrder(productId, orderRequest);
        emailService.sendEmailOrder(productId, orderRequest);
        return ResponseEntity.ok(null);
    }
}
