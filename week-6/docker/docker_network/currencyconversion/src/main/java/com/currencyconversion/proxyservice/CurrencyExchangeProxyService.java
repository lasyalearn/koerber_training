package com.currencyconversion.proxyservice;

import com.currencyconversion.dto.CurrencyConversionBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


// the name should be same as the name in eureka server

@FeignClient(name = "currency-exchange",url="http://currency-exchange:8080",fallback = CurrencyExchangeFallback.class)
//@FeignClient(name = "currency-exchange",url="http://localhost:8080",fallback = CurrencyExchangeFallback.class)

public interface  CurrencyExchangeProxyService
{
    Logger logger = LoggerFactory.getLogger(CurrencyExchangeProxyService.class);
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyConversionBean retrieveExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to);
}
