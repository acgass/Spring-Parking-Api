package com.acgass.springparkingapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.acgass.springparkingapi", "com.acgass.springparkingapi.Service"})
public class SpringParkingApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringParkingApiApplication.class, args);
	}

}
