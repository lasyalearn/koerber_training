package com.currencyexchange.service;

import com.currencyexchange.dto.ExchangeValue;

public interface ExchangeValueService
{
    ExchangeValue findByFromAndTo(String from, String to);
}
