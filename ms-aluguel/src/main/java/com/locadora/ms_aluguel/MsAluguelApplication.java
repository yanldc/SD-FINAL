package com.locadora.ms_aluguel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsAluguelApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsAluguelApplication.class, args);
	}

}
