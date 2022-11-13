package com.boujdi.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.Versioned;

import java.util.Map;

@SpringBootApplication
public class ConfigurationsApplication {
	@Autowired
  private VaultTemplate vaultTemplate;
	public static void main(String[] args) {
		SpringApplication.run(ConfigurationsApplication.class, args);
	}

	/*@Bean
	public String getSecret() {
		return vaultTemplate.read("secret/mysecret").getData().get("password").toString();
	}*/

	@Bean
	CommandLineRunner runner() {
		return args -> {
			Versioned.Metadata put = vaultTemplate
					.opsForVersionedKeyValue("secret")
					.put("kaypair", Map.of("password", "123456", "username", "boujdi", "email", "boujdii.me@gmail.com"));

		};
	}

}
