package com.example.TesteSpring.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.TesteSpring.entities.Category;
import com.example.TesteSpring.entities.Order;
import com.example.TesteSpring.entities.User;
import com.example.TesteSpring.enums.OrderStatus;
import com.example.TesteSpring.repository.CategoryRepository;
import com.example.TesteSpring.repository.OrderRepository;
import com.example.TesteSpring.repository.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public void run(String... args) throws Exception {
		User u = new User(null, "Valdir Castro", "valdircaf@hotmail.com", "9961428800");
		User u1 = new User(null, "Ana Thereza", "aninharamos@hotmail.com", "991996755");
		userRepository.saveAll(Arrays.asList(u, u1));
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T03:42:10Z"), u1, OrderStatus.PAID);
		Order o2 = new Order(null, Instant.parse("2019-06-20T03:42:10Z"), u1, OrderStatus.CANCELED);		
		orderRepository.saveAll(Arrays.asList(o1, o2));
		
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
	}
	
	
}
