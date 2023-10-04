package com.example.TesteSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TesteSpring.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
