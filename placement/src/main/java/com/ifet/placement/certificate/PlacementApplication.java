package com.ifet.placement.certificate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PlacementApplication {

	public static void main(String[] args) {
		// run in application context beam
		SpringApplication.run(PlacementApplication.class, args);
	}
}
