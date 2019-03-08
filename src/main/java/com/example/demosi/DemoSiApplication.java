package com.example.demosi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.config.EnableIntegration;

@EnableIntegration
@SpringBootApplication
@ImportResource({"classpath:context.xml"})
public class DemoSiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSiApplication.class, args);
	}

}
