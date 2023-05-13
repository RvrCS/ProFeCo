package com.ProConsumoApp.ProConsumoApp;

import com.ProConsumoApp.ProConsumoApp.Models.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ProConsumoAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProConsumoAppApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}



}
