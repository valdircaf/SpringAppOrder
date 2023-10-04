package com.example.TesteSpring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TesteSpring.entities.Order;
import com.example.TesteSpring.repository.OrderRepository;

@Service
public class OrderServices {
	
	@Autowired
	private OrderRepository repository;
	
	public List<Order> findAll(){
		List<Order> obj = repository.findAll();
		return obj;
	}
	
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}
}
