package com.productapp;

import com.productapp.repo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;

@SpringBootApplication
public class ProductappApplication implements CommandLineRunner {

	@Autowired
	private MongoTemplate mongoTemplate;

	public static void main(String[] args) {
		SpringApplication.run(ProductappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("----------- MongoDB Operations -----------");

		insert();                 // Insert a single product
		insertMultiple();         // Insert multiple products
		findAllProducts();        // Retrieve all products
		findByName("mouse");      // Find a product by name
		updateProduct("Keyboard", 700.0);  // Update product cost
		deleteProduct("mouse");   // Delete a product

		System.out.println("----------- Operations Completed -----------");
	}

	// Insert a single product
	private void insert() {
		mongoTemplate.save(new Product("dell laptop", 30, "AB electronic", 5000000.0));
		System.out.println("Inserted single product: Dell Laptop");
	}

	// Insert multiple products
	private void insertMultiple() {
		List<Product> products = List.of(
				new Product("mouse", 300, "MA electronic", 500.0),
				new Product("Keyboard", 20, "ZA electronic", 600.0),
				new Product("Monitor", 50, "Samsung", 20000.0),
				new Product("Headphones", 100, "Sony", 1500.0),
				new Product("Speaker", 40, "JBL", 5000.0)
		);
		mongoTemplate.insertAll(products);
		System.out.println("Inserted multiple products successfully!");
	}

	// Find all products
	private void findAllProducts() {
		List<Product> products = mongoTemplate.findAll(Product.class);
		System.out.println("All Products in Database:");
		products.forEach(System.out::println);
	}

	// Find product by name
	private void findByName(String name) {
		Query query = new Query();
		query.addCriteria(Criteria.where("name").is(name));
		Product product = mongoTemplate.findOne(query, Product.class);

		if (product != null) {
			System.out.println("Product Found: " + product);
		} else {
			System.out.println("Product not found!");
		}
	}

	// Update product cost by name
	private void updateProduct(String name, Double newCost) {
		Query query = new Query();
		query.addCriteria(Criteria.where("name").is(name));

		Update update = new Update();
		update.set("cost", newCost);

		Product updatedProduct = mongoTemplate.findAndModify(query, update, Product.class);
		if (updatedProduct != null) {
			System.out.println("Updated Product: " + updatedProduct);
		} else {
			System.out.println("Product not found!");
		}
	}

	// Delete product by name
	private void deleteProduct(String name) {
		Query query = new Query();
		query.addCriteria(Criteria.where("name").is(name));
		Product deletedProduct = mongoTemplate.findAndRemove(query, Product.class);

		if (deletedProduct != null) {
			System.out.println("Deleted Product: " + deletedProduct);
		} else {
			System.out.println("Product not found!");
		}
	}
}
