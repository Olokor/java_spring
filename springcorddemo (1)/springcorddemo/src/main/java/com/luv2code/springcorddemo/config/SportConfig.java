package com.luv2code.springcorddemo.config;

import com.luv2code.springcorddemo.rest.FootballCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
    @Bean
    public FootballCoach footballCoach(){
        return new FootballCoach();
    }
}
