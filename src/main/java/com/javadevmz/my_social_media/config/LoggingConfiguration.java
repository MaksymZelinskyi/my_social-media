package com.javadevmz.my_social_media.config;

import jakarta.persistence.Column;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Logger;

@Configuration
public class LoggingConfiguration {

    @Bean
    public Logger logger(){
        return Logger.getLogger(LoggingConfiguration.class.getName());
    }
}
