
package com.boujdi.configurations.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@ConfigurationProperties("user") // to bind the properties to this class instead of @Value("${token.accessTokenTimeout}")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component("vaultConfig")
public class VaultConfig {
    private String username;
    private String password;
    private String otp;
}

