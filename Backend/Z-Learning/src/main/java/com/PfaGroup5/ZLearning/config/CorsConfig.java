package com.PfaGroup5.ZLearning.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.List;

@Configuration
public class CorsConfig {
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        // Autoriser les origines nécessaires
        config.setAllowedOriginPatterns(List.of(
            "https://rssplearning.tech",
            "http://localhost:8080",
            "http://*.rssplearning.tech",
            "https://*.rssplearning.tech",
            "http://localhost:3000",
            "http://frontend-service:3000",
            "http://backend-service:8080"
        ));

        // Autoriser toutes les méthodes HTTP
        config.addAllowedMethod("*");

        // Autoriser tous les headers
        config.addAllowedHeader("*");

        // Autoriser les credentials (cookies)
        config.setAllowCredentials(true);

        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}