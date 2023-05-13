package com.ProConsumoApp.ProConsumoApp.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfiguration{

    @Bean
    public UserDetailsService userDetailsService(){
        return new CustomUserDetailsService();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
          http.csrf().disable()
                    .authorizeHttpRequests()
                    .requestMatchers("/","/register","/test/**", "/api/user/**").permitAll()
                    .and()
                    .authorizeHttpRequests().requestMatchers("/consumidor/**").hasAuthority("CONSUMIDOR")
                    .and()
                    .authorizeHttpRequests().requestMatchers("supermercado/**").hasAuthority("SUPERMERCADO")
                    .and()
                    .formLogin()
                        .loginPage("/login")
                        .usernameParameter("email")
                        .defaultSuccessUrl("/consumidor/home", true).permitAll()
                        .failureUrl("/login?error=true")
                    .and()
                        .logout()
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/");
        return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Bean
    AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService());
        provider.setPasswordEncoder(passwordEncoder());

        return provider;


    }
}
