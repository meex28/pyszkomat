package com.isi.pyszkomat.service.api.gateway.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "routing.service.uri")
@Getter
@Setter
public class ServicesUriConfig {
    private String payment;
    private String order;
    private String delivery;
}
