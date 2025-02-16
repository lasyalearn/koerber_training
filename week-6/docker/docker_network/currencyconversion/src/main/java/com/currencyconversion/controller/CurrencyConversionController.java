package com.currencyconversion.controller;


import com.currencyconversion.dto.CurrencyConversionBean;
import com.currencyconversion.proxyservice.CurrencyExchangeProxyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyConversionController
{
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(CurrencyConversionController.class);
    CurrencyExchangeProxyService currencyExchangeProxyService;
    @Autowired
    public CurrencyConversionController(CurrencyExchangeProxyService currencyExchangeProxyService)
    {
        this.currencyExchangeProxyService = currencyExchangeProxyService;
    }
    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean convertCurrencyFeign(@PathVariable String from,
                                                       @PathVariable String to,
                                                       @PathVariable BigDecimal quantity) {

        logger.info("Inside convertCurrencyFeign method");
        CurrencyConversionBean response = currencyExchangeProxyService.retrieveExchangeValue(from, to);



        CurrencyConversionBean  currencyConversionBean= new CurrencyConversionBean(response.getId(), from, to, response.getConversionMultiple(), quantity,
                quantity.multiply(response.getConversionMultiple()), response.getPort());
        logger.info("end convertCurrencyFeign method");
        return currencyConversionBean;
    }

}
