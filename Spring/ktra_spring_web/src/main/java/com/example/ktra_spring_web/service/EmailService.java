package com.example.ktra_spring_web.service;

import com.example.ktra_spring_web.entity.Appointment;
import com.example.ktra_spring_web.entity.Product;
import com.example.ktra_spring_web.exception.NotFoundException;
import com.example.ktra_spring_web.model.request.OrderRequest;
import com.example.ktra_spring_web.repository.ProductRepository;
import com.example.ktra_spring_web.statics.Status;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import javax.validation.Valid;

@Service
@AllArgsConstructor
public class EmailService {

    ProductRepository productRepository;

    JavaMailSender javaMailSender;


    public void sendEmailOrder(Integer productId, @Valid OrderRequest orderRequest) throws NotFoundException {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new NotFoundException("Product Not found !"));

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(orderRequest.getEmail());
        message.setSubject("Confirmation of Order");
        message.setText("Thank you for your order. Your order for " + product.getName() + " has been placed successfully.");

        javaMailSender.send(message);
    }

    public void sendEmailConfirmAppointment(Appointment appointment) {
    }
}