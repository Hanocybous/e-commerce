package com.hanocybous.ecommercesystem.config.securityconfig.securityconfigimpl;

import com.hanocybous.ecommercesystem.config.securityconfig.ISecurityConfig;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@Getter
class SecurityConfig implements ISecurityConfig {

    private final UserDetailsService userDetailsService;

    @Autowired
    public SecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    public PasswordEncoder getPasswordEncoder() {
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence) {
                return charSequence.toString();
            }

            @Override
            public boolean matches(CharSequence charSequence,
                                   String s) {
                return charSequence.toString().equals(s);
            }
        };
    }

    @Override
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Deprecated(since = "1.0.0", forRemoval = true)
    public void configure(@NotNull HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .requestMatchers("/api/v1/user/**").hasRole("USER")
                .requestMatchers("/api/v1/admin/**").hasRole("ADMIN")
                .requestMatchers("/api/v1/product/**").hasRole("PRODUCT")
                .requestMatchers("/api/v1/customer/**").hasRole("CUSTOMER")
                .requestMatchers("/api/v1/seller/**").hasRole("SELLER")
                .requestMatchers("/api/v1/review/**").hasRole("REVIEW")
                .requestMatchers("/api/v1/order/**").hasRole("ORDER")
                .requestMatchers("/api/v1/cart/**").hasRole("CART")
                .requestMatchers("/api/v1/payment/**").hasRole("PAYMENT")
                .anyRequest().authenticated();
    }

}
