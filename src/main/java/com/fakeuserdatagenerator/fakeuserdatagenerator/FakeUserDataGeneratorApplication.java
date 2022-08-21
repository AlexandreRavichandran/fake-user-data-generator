package com.fakeuserdatagenerator.fakeuserdatagenerator;

import com.github.javafaker.Faker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FakeUserDataGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(FakeUserDataGeneratorApplication.class, args);
	}

	@Bean
	public Faker javaFaker(){
		return new Faker();
	}
}
