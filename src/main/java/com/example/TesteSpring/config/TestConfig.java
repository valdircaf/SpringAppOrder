package com.example.TesteSpring.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.TesteSpring.entities.Category;
import com.example.TesteSpring.entities.Order;
import com.example.TesteSpring.entities.OrderItem;
import com.example.TesteSpring.entities.Product;
import com.example.TesteSpring.entities.User;
import com.example.TesteSpring.enums.OrderStatus;
import com.example.TesteSpring.repository.CategoryRepository;
import com.example.TesteSpring.repository.OrderItemRepository;
import com.example.TesteSpring.repository.OrderRepository;
import com.example.TesteSpring.repository.ProductRepository;
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
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
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
		
		Product p1 = new Product(null, "TV", "TV SAMSUNG 35P", 5000.00, "https://foto.com.br");
		Product p2 = new Product(null, "PC Gamer", "PC GAMER", 10000.00, "https://PC.com.br");
		Product p3 = new Product(null, "Harry Potter Book", "Book", 100.00, "https://harry.com.br");
		productRepository.saveAll(Arrays.asList(p1,p2, p3));
		
		p1.getCategories().add(cat1);
		p1.getCategories().add(cat3);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat2);
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		OrderItem oi1 = new OrderItem(p1, o1, p1.getPrice(), 1);
		OrderItem oi2 = new OrderItem(p2, o2, p2.getPrice(), 2);
		OrderItem oi3 = new OrderItem(p2, o1, p2.getPrice(), 1);
		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3));
	}
	
	
}
