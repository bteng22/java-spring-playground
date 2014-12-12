package com.thoughtworks.sweetnass.config;

import com.thoughtworks.sweetnass.repository.PeopleRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public PeopleRepository transferService() {
        return new PeopleRepository();
    }
}