package me.ubmagh.apgestionetudiants.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration // first type of classes to be instanciated
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin(); // default login page
        http.authorizeRequests().antMatchers("/").permitAll();
    }


}
