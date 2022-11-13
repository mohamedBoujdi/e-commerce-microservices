package com.boujdi.configurations.beans;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@ConfigurationProperties("token") // to bind the properties to this class instead of @Value("${token.accessTokenTimeout}")
@Data
@Component
public class ConsulConfig {
    private long accessTokenTimeout;
    private long refreshTokenTimeout;
}
