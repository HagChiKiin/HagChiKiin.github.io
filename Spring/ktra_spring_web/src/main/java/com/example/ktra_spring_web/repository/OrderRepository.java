package com.example.ktra_spring_web.repository;

import com.example.ktra_spring_web.entity.Order;
import com.example.ktra_spring_web.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
