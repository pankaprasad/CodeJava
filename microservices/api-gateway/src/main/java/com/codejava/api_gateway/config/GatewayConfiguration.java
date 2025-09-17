package com.codejava.api_gateway.config;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfiguration {

    // Inject DiscoveryClient to use service discovery (e.g., Eureka)
    private final DiscoveryClient discoveryClient;

    public GatewayConfiguration(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                // Employee Service Route
                .route("employee-service", r -> r.path("/employee/**")
                        .uri("lb://employee-service"))

                // Department Service Route
                .route("department-service", r -> r.path("/department/**")
                        .uri("lb://department-service"))

                .build();
    }
}