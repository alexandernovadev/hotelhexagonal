package com.hotels.mart.infrastructure.config;

// import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfig {

    // @Bean
    // public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    //     http
    //         .authorizeRequests(authorize -> authorize
    //             .antMatchers("/api/v1/auth/**", "/v3/api-docs/**", "/v3/api-docs.yaml", "/swagger-ui/**", "/swagger-ui.html").permitAll()
    //             .anyRequest().authenticated()
    //         )
    //         .httpBasic().disable() // If you want to disable HTTP Basic authentication
    //         .formLogin().disable(); // If you want to disable form login
    //     return http.build();
    // }
}
