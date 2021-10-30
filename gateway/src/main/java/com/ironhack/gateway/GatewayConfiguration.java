package com.ironhack.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfiguration {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        return builder.routes()

                // Lead service
                .route(p -> p.path("/api/v1/animal**")
                        .uri("lb://ANIMAL-SERVICE"))
                .route(p -> p.path("/api/v1/animal/**")
                        .uri("lb://ANIMAL-SERVICE"))

                // Opportunity service
                .route(p -> p.path("/api/v1/adopter**")
                        .uri("lb://ADOPTER-SERVICE"))

                .build();
    }
}
