package com.vehicle.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

       @Bean
       public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
              http.csrf(csrf->csrf.disable()).authorizeHttpRequests(auth->auth.requestMatchers("/actuator/**")
                      .permitAll().anyRequest().authenticated())
                      .httpBasic(HttpBasic->{});
              return http.build();
       }
       @Bean
       public UserDetailsService userDetailsService(){
           UserDetails user= User.withDefaultPasswordEncoder().username("config-user")
                   .password("${CONFIG_SERVER_PASSWORD:config123}")
                   .roles("CONFIG").build();
           return new InMemoryUserDetailsManager(user);
       }
}
