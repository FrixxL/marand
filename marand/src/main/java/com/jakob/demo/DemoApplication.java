package com.jakob.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jakob.demo.Doktor.Doktor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


}
