package com.currencyconversion.proxyservice;

import com.currencyconversion.dto.CurrencyConversionBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
// the name should be same as the name in eureka server
@FeignClient(name = "ce",fallback = CurrencyExchangeFallback.class)
public interface  CurrencyExchangeProxyService
{
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyConversionBean retrieveExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to);
}
