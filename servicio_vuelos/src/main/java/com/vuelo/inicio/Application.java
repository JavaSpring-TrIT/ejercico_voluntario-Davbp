package com.vuelo.inicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = "com.vuelo.model")
@EnableJpaRepositories(basePackages = "com.vuelo.dao")
@SpringBootApplication(scanBasePackages = {"com.vuelo.controller", "com.vuelo.service", "com.vuelo.inicio"}, exclude = {SecurityAutoConfiguration.class })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
