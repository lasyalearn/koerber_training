package com.currencyexchange.controller;


import com.currencyexchange.dto.ExchangeValue;
import com.currencyexchange.service.ExchangeValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
@RefreshScope
@RestController
public class ExchangeValueController
{
    ExchangeValueService exchangeValueService;
    Environment environment;
    @Value("${app.name}")
    private String appName;
    @Autowired
    public ExchangeValueController(ExchangeValueService exchangeValueService, Environment environment)
    {
        this.exchangeValueService = exchangeValueService;
        this.environment = environment;
    }

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to)
    {
        ExchangeValue exchangeValue=exchangeValueService.findByFromAndTo(from, to);
        exchangeValue.setPort(Integer.parseInt(Objects.requireNonNull(environment.getProperty("local.server.port"))));
        return exchangeValue;
    }
    @GetMapping("/name")
    public String getName()
    {
        return appName;
    }
}
