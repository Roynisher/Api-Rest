package com.rjt.server.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.rjt"})
public class BootRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootRestApplication.class, args);
	}

}
