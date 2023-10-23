package com.hanocybous.ecommercesystem.config.securityconfig;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface ISecurityConfig {

    PasswordEncoder getPasswordEncoder();

    PasswordEncoder passwordEncoder();

    void configure(HttpSecurity http) throws Exception;

}
