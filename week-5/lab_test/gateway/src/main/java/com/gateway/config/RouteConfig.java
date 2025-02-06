package com.gateway.config;


import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig
{
    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder)
    {
        return builder.routes()
                .route(r-> r
                        .path("/CompanyApp/DepartmentsMs/**")
                        .filters(f-> f
                                .rewritePath("/CompanyApp/DepartmentsMs/(?<segment>.*)","/${segment}")
                                .addResponseHeader("Access-Control-Allow-Origin", "*")
                                .circuitBreaker(config->config.setName("myCircuitBreaker").setFallbackUri("forward:/fallback")))
                        .uri("lb://deptapp"))
                .route(r->r
                        .path("/CompanyApp/EmployeesMs/**")
                        .filters(f->f
                                .rewritePath("/CompanyApp/EmployeesMs/(?<segment>.*)","/${segment}")
                                .addResponseHeader("Access-Control-Allow-Origin", "*")
                                .circuitBreaker(config->config.setName("myCircuitBreaker").setFallbackUri("forward:/fallback")))
                        .uri("lb://empapp")).build();
    }
}
