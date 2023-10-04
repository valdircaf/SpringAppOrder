package com.example.TesteSpring.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.TesteSpring.entities.Order;
import com.example.TesteSpring.services.OrderServices;

@RequestMapping(value = "/orders")
@RestController
public class OrderResources {
	
	@Autowired
	private OrderServices service;
	
	@GetMapping
	private ResponseEntity<List<Order>> findAll(){
		List<Order> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	private ResponseEntity<Order> findById(@PathVariable Long id){
		Order order = service.findById(id);
		return ResponseEntity.ok().body(order);
	}
}
