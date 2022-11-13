package com.boujdi.configurations.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("token") // to bind the properties to this class instead of @Value("${token.accessTokenTimeout}")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsulConfig {
    private long accessTokenTimeout;
    private long refreshTokenTimeout;


}
