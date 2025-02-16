package com.currencyexchange.dao;


import com.currencyexchange.dto.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeValueRepo extends JpaRepository<ExchangeValue, Long>
{
    ExchangeValue findByFromAndTo(String from, String to);
}
