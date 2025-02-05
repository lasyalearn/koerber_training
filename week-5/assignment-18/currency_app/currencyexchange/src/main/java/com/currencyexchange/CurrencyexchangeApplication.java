package com.currencyexchange;

import com.currencyexchange.dao.ExchangeValueRepo;
import com.currencyexchange.dto.ExchangeValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.math.BigDecimal;
import java.util.List;

@EnableDiscoveryClient
@SpringBootApplication
public class CurrencyexchangeApplication implements CommandLineRunner
{
	@Autowired
	ExchangeValueRepo exchangeValueRepo;
	public static void main(String[] args) {
		SpringApplication.run(CurrencyexchangeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception
	{
		exchangeValueRepo.save(new ExchangeValue("USD", "INR", new BigDecimal(85)));
		exchangeValueRepo.save(new ExchangeValue("EURO", "INR", new BigDecimal(95)));


		List<ExchangeValue> list=exchangeValueRepo.findAll();
		list.forEach(System.out::println);
		System.out.println("----------------------");

	}
}
