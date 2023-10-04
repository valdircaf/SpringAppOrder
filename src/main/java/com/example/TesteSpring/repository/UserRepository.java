package com.example.TesteSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TesteSpring.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
