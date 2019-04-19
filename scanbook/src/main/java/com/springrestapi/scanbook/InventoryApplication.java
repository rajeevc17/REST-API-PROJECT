package com.springrestapi.scanbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class InventoryApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(InventoryApplication.class, args);
	}

}
