package com.isi.pyszkomat.service.api.gateway.config;

import lombok.AllArgsConstructor;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class GatewayConfig {
    private final ServicesUriConfig servicesUriConfig;

    @Bean
    public RouteLocator paymentRoute(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("payment-service", r -> r
                        .path("/api/payment/**")
                        .filters(f -> f.rewritePath("/api/payment/(?<segment>.*)", "/api/${segment}"))
                        .uri(servicesUriConfig.getPayment())
                )
                .build();
    }
}