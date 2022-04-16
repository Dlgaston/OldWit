package com.app.wit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.app")
public class WitApplication {

	public static void main(String[] args) {
		SpringApplication.run(WitApplication.class, args);
	}

}
