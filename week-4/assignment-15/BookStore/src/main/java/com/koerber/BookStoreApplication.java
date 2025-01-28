package com.koerber;

import com.koerber.dao.BookStoreDao;
import com.koerber.dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class BookStoreApplication implements CommandLineRunner
{
	// change the double price to BigDecimal
	// new book BigDecimal.valueOf(10.00)
	//server.port=8081
	// to give the rootpath
	// server.servelet.context-path=/BookStore
	//custom http status code message
	//	Step 1. Provide support for CURD operation --> done
	//	Step 2.  Proper ResponseEntity should be returned as per requirments --> done
	//	Step 3. study http status code and return appropiate status code --> done
	//	Step 4: Apply Exception handing to rest controller --> done
	//	Step 5: Apply Validation using JSR 303 -->done
	//  Step 6: no map  connection to database -> mysql --> doing

	@Autowired
	private BookStoreDao bookStoreDao;
	public static void main(String[] args)
	{

		SpringApplication.run(BookStoreApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception
	{
		bookStoreDao.save(new Book(1, "S001", "Harry Potter and the Chamber of Secrets" , "J k Rowling", BigDecimal.valueOf(600.00)));
		bookStoreDao.save(new Book(2, "S002", "Harry Potter and the Philosopher Stone" , "J k Rowling", BigDecimal.valueOf(700.00)));
	}

}
