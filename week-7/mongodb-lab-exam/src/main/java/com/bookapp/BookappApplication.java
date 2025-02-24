package com.bookapp;

import com.bookapp.entities.JournalEntry;
import com.bookapp.entities.User;
import com.bookapp.exceptions.ResourceNotFoundException;
import com.bookapp.repo.JournalEntryRepo;
import com.bookapp.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.print.Book;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class BookappApplication implements CommandLineRunner {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private JournalEntryRepo journalEntryRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(BookappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception
	{
		journalEntryRepo.deleteAll();
		userRepo.deleteAll();

		JournalEntry journalEntry1 = journalEntryRepo.save(new JournalEntry("journal1", "content1", LocalDateTime.now()));
		JournalEntry journalEntry2 = journalEntryRepo.save(new JournalEntry("journal2", "content2", LocalDateTime.now()));
		JournalEntry journalEntry3 = journalEntryRepo.save(new JournalEntry("journal3", "content3", LocalDateTime.now()));
		JournalEntry journalEntry4 = journalEntryRepo.save(new JournalEntry("journal4", "content4", LocalDateTime.now()));
		User user1 = new User("user1", "email1");
		User user2 = new User("user2", "email2");


		user1.getJournalEntries().add(journalEntry1);
		user1.getJournalEntries().add(journalEntry2);
		user2.getJournalEntries().add(journalEntry3);
		user2.getJournalEntries().add(journalEntry4);


		userRepo.save(user1);
		userRepo.save(user2);



		System.out.println("Users: " + userRepo.findAll().size());
		System.out.println("Journal Entries: " + journalEntryRepo.findAll().size());
	}
}
