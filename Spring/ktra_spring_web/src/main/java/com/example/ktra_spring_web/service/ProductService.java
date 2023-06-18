package com.example.ktra_spring_web.service;

import com.example.ktra_spring_web.entity.Product;
import com.example.ktra_spring_web.exception.NotFoundException;
import com.example.ktra_spring_web.model.request.ProductRequest;
import com.example.ktra_spring_web.model.response.AppointmentResponse;
import com.example.ktra_spring_web.model.response.ProductResponse;
import com.example.ktra_spring_web.repository.AppointmentRepository;
import com.example.ktra_spring_web.repository.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductService {

    ObjectMapper objectMapper;

    ProductRepository productRepository;

    AppointmentRepository appointmentRepository;

    public List<ProductResponse> getAllProduct() {
        return productRepository.findAll()
                .stream()
                .map(p -> objectMapper.convertValue(p, ProductResponse.class))
                .collect(Collectors.toList());
    }

    public ProductResponse saveProduct(ProductRequest request) {
        Product product = objectMapper.convertValue(request, Product.class);
        productRepository.save(product);
        return objectMapper.convertValue(product, ProductResponse.class);
    }

    public ProductResponse updateProduct(Integer id, ProductRequest productRequest) throws NotFoundException {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Not found product")
                );

        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        product.setDescription(productRequest.getDescription());
        product.setImage(productRequest.getImage());
        productRepository.save(product);

        return objectMapper.convertValue(product, ProductResponse.class);
    }

    public List<AppointmentResponse> getAllAppointment() {
        return appointmentRepository.findAll()
                .stream()
                .map(a -> objectMapper.convertValue(a, AppointmentResponse.class))
                .collect(Collectors.toList());
    }

//    public void deleteProduct(Integer id) throws NotFoundException {
//        Product product = productRepository.findById(id)
//                .orElseThrow(() -> new NotFoundException("Not found product")
//                );
//        productRepository.delete(product);
//    }
}
