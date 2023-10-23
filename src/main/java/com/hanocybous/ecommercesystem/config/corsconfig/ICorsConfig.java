package com.hanocybous.ecommercesystem.config.corsconfig;

import org.jetbrains.annotations.NotNull;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

public interface ICorsConfig {

    void addCorsMappings(@NotNull CorsRegistry registry);

}
