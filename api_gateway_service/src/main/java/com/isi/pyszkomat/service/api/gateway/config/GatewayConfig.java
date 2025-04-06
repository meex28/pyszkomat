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
                .route("order-service", r -> r
                        .path("/api/order/**")
                        .filters(f -> f.rewritePath("/api/order/(?<segment>.*)", "/api/${segment}"))
                        .uri(servicesUriConfig.getOrder())
                )
                .route("delivery-service", r -> r
                        .path("/api/delivery/**")
                        .filters(f -> f.rewritePath("/api/delivery/(?<segment>.*)", "/api/${segment}"))
                        .uri(servicesUriConfig.getDelivery())
                )
                .build();
    }
}