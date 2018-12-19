package com.weather.openweather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.weather.controller"})
public class OpenweatherApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpenweatherApplication.class, args);
	}

}

