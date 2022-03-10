package com.springbootcrudexample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableFeignClients
@EnableCaching
@ComponentScan(basePackages = "com.springbootcrudexample.*")
@EntityScan("com.springbootcrudexample.*")
public class SpringBootCrudExampleApplication {
	private static final Logger logger= LoggerFactory.getLogger(SpringBootCrudExampleApplication.class);
	public static void main(String[] args) {
		logger.info("Started application");
		SpringApplication.run(SpringBootCrudExampleApplication.class, args);
	}

}
