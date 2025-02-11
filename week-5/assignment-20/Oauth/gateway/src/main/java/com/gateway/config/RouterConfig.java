package com.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
//
@Configuration
public class RouterConfig
{
    @Bean
    public RouteLocator routerLocator(RouteLocatorBuilder builder)
    {
        return builder.routes()
                .route(r->r
                        .path("/currencyapp/currencyExchangeMs/**")
                        .filters(f->f
                                .rewritePath("/currencyapp/currencyExchangeMs/(?<segment>.*)","/${segment}")
                                .addResponseHeader("X-Response-Time", LocalDateTime.now().toString())
                                .circuitBreaker(Config->Config.setName("myCircuitBreaker").setFallbackUri("forward:/currencySupport")))
                        .uri("lb://currencyexchange"))
                .route(r->r.path("/currencyapp/currencyConversionMs/**")
                        .filters(f->f
                                .rewritePath("/currencyapp/currencyConversionMs/(?<segment>.*)","/${segment}")
                                .addResponseHeader("X-Response-Time", LocalDateTime.now().toString())
                                .circuitBreaker(Config->Config.setName("myCircuitBreaker").setFallbackUri("forward:/currencySupport")))
                        .uri("lb://currencyconversion"))
                .build();

    }

}
