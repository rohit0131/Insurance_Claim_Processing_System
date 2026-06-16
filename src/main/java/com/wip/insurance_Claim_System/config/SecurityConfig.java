package com.wip.insurance_Claim_System.config;



import org.springframework.security.config.Customizer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())

            .authorizeHttpRequests(auth -> auth

                .requestMatchers("/admin/login", "/customer/login").permitAll()

                .requestMatchers("/admin/**").hasRole("ADMIN")

                
                .requestMatchers("/customer/**").hasAnyRole("ADMIN", "CUSTOMER")

                .requestMatchers("/claim/**").hasAnyRole("ADMIN", "CUSTOMER")

                .requestMatchers("/policy/**").hasAnyRole("ADMIN", "CUSTOMER")

                .requestMatchers("/approval/**").hasRole("ADMIN")

                .requestMatchers("/claimstatus/**").hasRole("ADMIN")

                .anyRequest().authenticated()
            )

            .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}