package com.recykal.Security_Http_Basic_Auth.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests((request) -> request
                .requestMatchers("/contact", "/about", "/swagger-ui-html").permitAll()
                .anyRequest().authenticated()
        ).httpBasic(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager configUsers() {
       UserDetails ashok =User.withDefaultPasswordEncoder()
                .username("ashok")
                .password("ashok")
                .authorities("ADMIN")
                .build();
       UserDetails john=  User.withDefaultPasswordEncoder()
                .username("john")
                .password("john")
                .authorities("USER")
                .build();
        return  new InMemoryUserDetailsManager(ashok,john);
    }



}


