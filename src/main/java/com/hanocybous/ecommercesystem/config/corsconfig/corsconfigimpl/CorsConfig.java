package com.hanocybous.ecommercesystem.config.corsconfig.corsconfigimpl;

import com.hanocybous.ecommercesystem.config.corsconfig.ICorsConfig;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@NoArgsConstructor
@EnableWebMvc
class CorsConfig implements WebMvcConfigurer, ICorsConfig {

    @Override
    public void addCorsMappings(@NotNull CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("http://localhost:5432")
                .allowedOrigins("http://localhost:8080")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("Authorization", "Content-Type")
                .exposedHeaders("Authorization")
                .allowCredentials(true)
                .maxAge(3600);
    }

}
