package com.br.equiplano.usecase.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class UseCaseConfig {

    @Bean
    public String teste(){
      log.info("ok");
        return "";
    }
}
