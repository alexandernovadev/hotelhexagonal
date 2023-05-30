package com.hotels.mart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.hotels.mart.infrastructure.config.WebConfig;

@SpringBootApplication
// @Import(WebConfig.class)
public class MysqljdbApplication {

	public static void main(String[] args) {
		SpringApplication.run(MysqljdbApplication.class, args);
		
	}

}
