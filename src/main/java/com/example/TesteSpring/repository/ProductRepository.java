package com.example.TesteSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TesteSpring.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
}
