package com.br.equiplano.application;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.web.reactive.config.EnableWebFlux;


@SpringBootApplication
@ComponentScan(basePackages = {"com.br.equiplano.*","com.br.equiplano.usecase.*","com.br.equiplano.repositorymongo.*"
		,"com.br.equiplano.exception.handle.*"})
@EnableReactiveMongoRepositories(basePackages = "com.br.equiplano.*")
@EnableWebFlux
@EntityScan(basePackages = "com.br.equiplano.repositorymongo.*")
@OpenAPIDefinition(info = @Info(title = "Api de teste equiplano", version = "1.0", description = "Documentação da API de teste v1.0"))
public class CustomerApplication {

	private static final Logger logger = LoggerFactory.getLogger(CustomerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
		logger.info("Iniciando app.");
	}

}
