package com.boujdi.configurations.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RefreshScope
// to refresh the configuration without restarting the application
public class ConsulRestConfigController {
    @Value("${token.accessTokenTimeout}")
    private long accessTockenTimeout;
    @Value("${token.refreshTokenTimeout}")
    private long refreshTokenTimeout;

    @GetMapping("/config")
    public Map<String, Long> getConfig() {
        return Map.of("accessTokenTimeout", accessTockenTimeout, "refreshTokenTimeout", refreshTokenTimeout);
    }
}
