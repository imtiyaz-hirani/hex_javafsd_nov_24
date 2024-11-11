package com.springboot.SpringHttpBasicSecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication //(exclude = SecurityAutoConfiguration.class)
public class SpringHttpBasicSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringHttpBasicSecurityApplication.class, args);
	}

}
