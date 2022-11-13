package com.boujdi.configurations.web;

import com.boujdi.configurations.entities.ConsulConfig;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RefreshScope
@AllArgsConstructor
// to refresh the configuration without restarting the application
public class ConsulRestConfigController {
    private ConsulConfig consulConfig; // to inject the configuration

    //===============================================================

  /*  @Value("${token.accessTokenTimeout}")
    private long accessTockenTimeout;
    @Value("${token.refreshTokenTimeout}")
    private long refreshTokenTimeout;*/

    //===============================================================

    @GetMapping("/config")
    public ConsulConfig getConfig() {
        //return Map.of("accessTokenTimeout", accessTockenTimeout, "refreshTokenTimeout", refreshTokenTimeout);
        return consulConfig;
    }
}
