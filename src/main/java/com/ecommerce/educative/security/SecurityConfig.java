package com.ecommerce.educative.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.ecommerce.educative.security.jwt.JWTAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  private BCryptPasswordEncoder bCryptPasswordEncoder;

  @Bean
  protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
        .csrf(csrf -> csrf.disable())
        .authorizeRequests()
        .antMatchers("/cart/**").permitAll()

        .antMatchers(HttpMethod.GET, "/category/**").permitAll()
        .antMatchers("/category/**").hasRole("admin")

        .antMatchers(HttpMethod.GET, "/product/**").permitAll()
        .antMatchers("/product/**").hasRole("admin")

        .antMatchers("/role/**").hasRole("admin")

        .antMatchers("/wishlist/**").permitAll()

        .antMatchers("/category/**").hasRole("admin")

        .antMatchers(HttpMethod.POST, "/user/**").permitAll()
        .antMatchers("/user/**").hasRole("admin")

        .anyRequest()
        .authenticated()
        .and()
        .addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .httpBasic(withDefaults());

    return http.build();
  }

  @Bean
  protected UserDetailsService userDetailsService() {
    UserDetails adminUser = User.builder()
        .username("admin")
        .password(bCryptPasswordEncoder.encode("admin2"))
        .roles("admin")
        .build();

    UserDetails user = User.builder()
        .username("user")
        .password(bCryptPasswordEncoder.encode("user2"))
        .roles("user")
        .build();

    return new InMemoryUserDetailsManager(
        adminUser, user);
  }

  @Bean
  public AuthenticationManager authenticationManager(
      AuthenticationConfiguration authenticationConfiguration) throws Exception {
    return authenticationConfiguration.getAuthenticationManager();
  }

  @Bean
  public JWTAuthenticationFilter jwtAuthenticationFilter() {
    return new JWTAuthenticationFilter();
  }
}
