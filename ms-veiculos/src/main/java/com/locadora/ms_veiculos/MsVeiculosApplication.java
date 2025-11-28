package com.locadora.ms_veiculos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsVeiculosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsVeiculosApplication.class, args);
	}

}
