package com.currencyexchange.service;

import com.currencyexchange.dao.ExchangeValueRepo;
import com.currencyexchange.dto.ExchangeValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExchangeValueServiceImpl implements ExchangeValueService
{

    private ExchangeValueRepo exchangeValueRepo;
    @Autowired
    public ExchangeValueServiceImpl(ExchangeValueRepo exchangeValueRepo)
    {
        this.exchangeValueRepo = exchangeValueRepo;
    }
    @Override
    public ExchangeValue findByFromAndTo(String from, String to)
    {
         return exchangeValueRepo.findByFromAndTo(from, to);
    }
}
