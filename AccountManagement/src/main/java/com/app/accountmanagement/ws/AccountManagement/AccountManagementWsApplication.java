package com.app.accountmanagement.ws.AccountManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AccountManagementWsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountManagementWsApplication.class, args);
	}

}
