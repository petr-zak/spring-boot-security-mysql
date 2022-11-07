package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain getSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/root", "/login", "/logout", "/logoutdone").permitAll()
                .and().authorizeRequests().antMatchers("/user").hasRole("USER")
                .and().authorizeRequests().antMatchers("/all").hasRole("ADMIN")
                .and().authorizeRequests().anyRequest().authenticated()
                .and().formLogin().defaultSuccessUrl("/root").failureUrl("/login?error").permitAll()
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/logoutdone")
                .and().httpBasic();
        return http.build();
    }

//    @Bean
//    public WebSecurityCustomizer getWebSecurityCustomizer() {
//        return (web) -> web.ignoring().antMatchers("/images/**");
//    }

}
