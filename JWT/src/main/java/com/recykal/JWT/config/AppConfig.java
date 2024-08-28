package com.recykal.JWT.config;

import com.recykal.JWT.filter.AppFilter;
import com.recykal.JWT.service.MyUserDetailsService;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class AppConfig {

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    private AppFilter filter;


    @Bean
    public PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return  configuration.getAuthenticationManager();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(myUserDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable()
                   .authorizeHttpRequests()
                   .requestMatchers("api/login","api/register").permitAll()
                   .and()
                   .authorizeHttpRequests().requestMatchers("/api/**")
                   .authenticated()
                   .and()
                   .sessionManagement()
                   .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                   .and()
                   .authenticationProvider(authenticationProvider())
                   .addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class).build();


    }



}
