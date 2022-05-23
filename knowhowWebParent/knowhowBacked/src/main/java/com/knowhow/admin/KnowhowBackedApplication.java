package com.knowhow.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({"com.knowhow.common.entity","com.knowhow.admin.user"})
public class KnowhowBackedApplication {

	public static void main(String[] args) {
		SpringApplication.run(KnowhowBackedApplication.class, args);
	}

}
