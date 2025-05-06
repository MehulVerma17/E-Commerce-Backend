package com.mehul.e.commerce.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/*")  // Apply to all endpoints
                        .allowedOrigins("") // Allow all origins (all ports/domains)
                        .allowedMethods("") // Allow all HTTP methods
                        .allowedHeaders("") // Allow all headers
                        .allowCredentials(false); // Disable if you're not using cookies or auth headers
            }
        };
    }
}
