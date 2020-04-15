package com.akansh.eureka.app.DiscoveryRegistoryService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscoveryRegistoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscoveryRegistoryServiceApplication.class, args);
	}

}
