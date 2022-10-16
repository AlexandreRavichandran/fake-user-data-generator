package com.fakeuserdatagenerator.fakeuserdatagenerator;

import com.github.javafaker.Faker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.BufferedImageHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;

import java.awt.image.BufferedImage;

@SpringBootApplication
public class FakeUserDataGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(FakeUserDataGeneratorApplication.class, args);
	}

	@Bean
	public Faker javaFaker(){
		return new Faker();
	}

	@Bean
	public HttpMessageConverter<BufferedImage> createImageHttpMessageConverter() {
		return new BufferedImageHttpMessageConverter();
	}
}
