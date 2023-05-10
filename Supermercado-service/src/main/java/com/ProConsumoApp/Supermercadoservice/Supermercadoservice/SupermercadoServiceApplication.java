package com.ProConsumoApp.Supermercadoservice.Supermercadoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SupermercadoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SupermercadoServiceApplication.class, args);
	}

}
