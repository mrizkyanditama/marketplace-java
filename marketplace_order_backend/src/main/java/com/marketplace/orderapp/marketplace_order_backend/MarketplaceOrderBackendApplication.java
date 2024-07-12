package com.marketplace.orderapp.marketplace_order_backend;

import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class MarketplaceOrderBackendApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MarketplaceOrderBackendApplication.class, args);

        Environment env = context.getEnvironment();
        System.out.println("Printing All Application Properties:");

        // Get all properties as a Map
        Map<String, Object> properties = ((org.springframework.core.env.StandardEnvironment) env).getSystemProperties();

        // Iterate over properties and print them
        for (Map.Entry<String, Object> entry : properties.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

		System.out.println("Database URL: " + env.getProperty("spring.datasource.url"));
        System.out.println("Database Username: " + env.getProperty("spring.datasource.username"));
	}

}
