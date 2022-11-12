// package com.ecommerce.educative.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import static org.springframework.security.config.Customizer.withDefaults;

// import org.springframework.security.web.SecurityFilterChain;

// @Configuration
// @EnableWebSecurity
// public class SecurityConfiguration {

//     @Bean
//     public SecurityFilterChain configure(HttpSecurity http) throws Exception {
//         return http
//                 .csrf(csrf -> csrf.disable())
//                 .authorizeRequests(auth -> {
//                     auth.antMatchers("/").permitAll();
//                     auth.antMatchers("/user").hasAnyRole("USER");
//                     auth.antMatchers("/admin").hasRole("ADMIN");
//                 })
//                 .httpBasic(withDefaults())
//                 .build();
//     }
// }
