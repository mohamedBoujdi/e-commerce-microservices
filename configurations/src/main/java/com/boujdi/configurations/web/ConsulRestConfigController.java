package com.boujdi.configurations.web;

import com.boujdi.configurations.beans.ConsulConfig;
import com.boujdi.configurations.beans.VaultConfig;
import lombok.AllArgsConstructor;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
@AllArgsConstructor
// to refresh the configuration without restarting the application
public class ConsulRestConfigController {
    private ConsulConfig consulConfig; // to inject the configuration from consul
    private VaultConfig vaultConfig; // to inject the configuration from vault

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
    @GetMapping("/secrets")
    public VaultConfig getSecrets() {
        //return Map.of("accessTokenTimeout", accessTockenTimeout, "refreshTokenTimeout", refreshTokenTimeout);
        return vaultConfig;
    }
}
