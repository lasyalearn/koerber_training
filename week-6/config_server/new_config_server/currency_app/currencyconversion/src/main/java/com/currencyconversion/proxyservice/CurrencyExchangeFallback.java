package com.currencyconversion.proxyservice;

import com.currencyconversion.dto.CurrencyConversionBean;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CurrencyExchangeFallback implements CurrencyExchangeProxyService
{
    @Override
    public CurrencyConversionBean retrieveExchangeValue(String from, String to)
    {
        return new CurrencyConversionBean(0L, from, to, new BigDecimal(0), new BigDecimal(0), new BigDecimal(0), 0);
    }
}
