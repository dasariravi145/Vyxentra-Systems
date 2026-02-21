package com.vehicle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CommonLibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommonLibraryApplication.class, args);
	}

}
