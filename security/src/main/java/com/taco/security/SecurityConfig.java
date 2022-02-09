package com.taco.security;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableAutoConfiguration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;

    public SecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
            .authorizeRequests()
            .antMatchers(HttpMethod.OPTIONS).permitAll() // needed for Angular/CORS
            .antMatchers("/design","/orders/**").permitAll()
            .antMatchers(HttpMethod.PATCH, "/ingredients").permitAll()
            .antMatchers("/**").access("permitAll")

            .and()
                .formLogin()
                .loginPage("/login")

            .and()
                .httpBasic()
                .realmName("Taco Cloud")

            .and()
                .logout()
                .logoutSuccessUrl("/")

            .and()
                .csrf()
                .ignoringAntMatchers("/h2-console/**", "/ingredients/**", "/design", "/orders/**")

            // Allow pages to be loaded in frames from the same origin. Needed for h2 console
            .and()
                .headers()
                .frameOptions()
                .sameOrigin();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth)throws Exception{
        auth
            .userDetailsService(userDetailsService)
            .passwordEncoder(encoder());
    }

    @Bean
    public PasswordEncoder encoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
