package com.ProductStore;

import com.ProductStore.dao.ProductDao;
import com.ProductStore.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootApplication
public class Assigment17Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Assigment17Application.class, args);
	}
	@Autowired
	private ProductDao productDao;
	@Override
	public void run(String... args) throws Exception
	{
		productDao.save(new Product("Laptop", new BigDecimal(15000), LocalDate.of(2024, 1, 15)));
		productDao.save(new Product("Mobile", new BigDecimal(8000), LocalDate.of(2024, 2, 10)));
		productDao.save(new Product("Television", new BigDecimal(25000), LocalDate.of(2024, 3, 5)));
		productDao.save(new Product("Tablet", new BigDecimal(5000), LocalDate.of(2024, 4, 20)));
		productDao.save(new Product("Camera", new BigDecimal(6000), LocalDate.of(2024, 5, 25)));
		productDao.save(new Product("Watch", new BigDecimal(4000), LocalDate.of(2024, 6, 10)));
		productDao.save(new Product("Headphones", new BigDecimal(3000), LocalDate.of(2024, 7, 1)));
		productDao.save(new Product("Keyboard", new BigDecimal(2000), LocalDate.of(2024, 8, 8)));
		productDao.save(new Product("Mouse", new BigDecimal(1000), LocalDate.of(2024, 9, 12)));
		productDao.save(new Product("Speaker", new BigDecimal(1500), LocalDate.of(2024, 10, 14)));
		productDao.save(new Product("Printer", new BigDecimal(5000), LocalDate.of(2024, 11, 22)));
		productDao.save(new Product("Scanner", new BigDecimal(3000), LocalDate.of(2024, 12, 30)));
		productDao.save(new Product("Monitor", new BigDecimal(2000), LocalDate.of(2025, 1, 17)));
		productDao.save(new Product("Router", new BigDecimal(1000), LocalDate.of(2025, 2, 5)));
		productDao.save(new Product("Switch", new BigDecimal(500), LocalDate.of(2025, 3, 12)));
		productDao.save(new Product("Printer", new BigDecimal(5000), LocalDate.of(2025, 4, 1)));
		productDao.save(new Product("Scanner", new BigDecimal(3000), LocalDate.of(2025, 5, 10)));


	}
}
