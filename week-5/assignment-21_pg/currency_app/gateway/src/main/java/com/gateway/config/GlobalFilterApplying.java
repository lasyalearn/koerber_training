package com.gateway.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class GlobalFilterApplying implements GlobalFilter
{
    private Logger logger = LoggerFactory.getLogger(GlobalFilterApplying.class);
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain)
    {
        logger.info("Inside Global Filter");
        logger.info("Request Method : {}",exchange.getRequest().getMethod());
        return chain.filter(exchange);
    }
}
