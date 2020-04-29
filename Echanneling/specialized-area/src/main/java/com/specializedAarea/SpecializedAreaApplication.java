package com.specializedAarea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpecializedAreaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpecializedAreaApplication.class, args);
	}

}
