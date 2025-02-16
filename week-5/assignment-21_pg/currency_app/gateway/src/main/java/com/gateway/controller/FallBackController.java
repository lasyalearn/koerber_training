package com.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FallBackController
{
    @GetMapping("/currencySupport")
    public Mono<String> fallbackMethod()
    {
        return Mono.just("Currency Service is Down");
    }
}
