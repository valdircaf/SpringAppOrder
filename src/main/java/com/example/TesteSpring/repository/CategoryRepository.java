package com.example.TesteSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TesteSpring.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
