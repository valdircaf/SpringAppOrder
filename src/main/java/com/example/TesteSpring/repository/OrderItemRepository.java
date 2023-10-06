package com.example.TesteSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TesteSpring.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
