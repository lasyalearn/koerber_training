package com.BankApp;

import com.BankApp.dao.BankDao;
import com.BankApp.dto.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.math.BigDecimal;


@SpringBootApplication
public class LabApplication implements CommandLineRunner
{
	BankDao bankDao;
	@Autowired
	LabApplication(BankDao bankDao)
	{
		this.bankDao = bankDao;
	}

	public static void main(String[] args)
	{
		SpringApplication.run(LabApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception
	{
//		bankDao.save(new Account(1,"Ravi","Savings", BigDecimal.valueOf(5000)));
//		bankDao.save(new Account(2,"Sugeetha","Current", BigDecimal.valueOf(10000)));
//		bankDao.save(new Account(3,"Karthik","Savings", BigDecimal.valueOf(6000)));
	}

}
