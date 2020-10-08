package com.microservice.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com")
@EnableFeignClients(basePackages= {"com.microservice.config","com.microservice.restTemplateProxy"})
//if it is not imported we need to change cloud version in pom.xml and component scan does not know about feign client 
//so we have to add interface package in enablefeignclient
@EnableDiscoveryClient
public class CurrencyConverterServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConverterServiceApplication.class, args);
	}

}
