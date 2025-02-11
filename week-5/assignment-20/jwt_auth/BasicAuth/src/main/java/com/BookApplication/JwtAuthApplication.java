package com.BookApplication;

import com.BookApplication.dao.BookRepo;
import com.BookApplication.dto.Book;
import com.BookApplication.entites.UserEntity;
import com.BookApplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootApplication
public class JwtAuthApplication implements CommandLineRunner
{
	@Autowired
	UserService userService;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	BookRepo bookRepo;
	public static void main(String[] args) {
		SpringApplication.run(JwtAuthApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception
	{
		bookRepo.save(new Book("The Lord of the Rings", "JRR Tolkien", 1000));
		bookRepo.save(new Book("The Hobbit", "JRR Tolkien", 500));
		bookRepo.save(new Book("The Silmarillion", "JRR Tolkien", 300));
		bookRepo.save(new Book("The Fellowship of the Ring", "JRR Tolkien", 500));
		bookRepo.save(new Book("The Two Towers", "JRR Tolkien", 500));
		bookRepo.save(new Book("The Return of the King", "JRR Tolkien", 500));

		//userEntity.addUserEntity("admin", passwordEncoder.encode("admin"), List.of("Teacher"));

		userService.addUserEntity(new UserEntity("jeny",
				passwordEncoder.encode("jeny123"), List.of("ROLE_Teacher","ROLE_Student")));

		userService.addUserEntity(new UserEntity("lasya",passwordEncoder.encode("lasya123"),
				List.of("ROLE_Student")));

	}
}
