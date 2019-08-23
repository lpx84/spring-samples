package com.percylee.sample.rediscache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class RedisCacheSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisCacheSampleApplication.class, args);
	}

}
