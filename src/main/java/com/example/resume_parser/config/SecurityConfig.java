package com.example.resume_parser.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth.requestMatchers("/login", "/css/**").
                permitAll().requestMatchers("/resume-parser").
                authenticated().anyRequest().authenticated()).formLogin(login -> {
            login.loginPage("/login").loginProcessingUrl("/login").
                    defaultSuccessUrl("/resume-parser", true).permitAll();
        }).logout(logout -> {
            logout.invalidateHttpSession(true).clearAuthentication(true).
                    logoutRequestMatcher(new AntPathRequestMatcher("/logout")).
                    logoutSuccessUrl("/login?logout").permitAll();
        });

        return http.build();

    }


    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder().username("user").password("password").roles("USER").build();
        return new InMemoryUserDetailsManager(user);
    }
}