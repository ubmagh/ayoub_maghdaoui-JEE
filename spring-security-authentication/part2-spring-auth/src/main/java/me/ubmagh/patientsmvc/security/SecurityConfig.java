package me.ubmagh.patientsmvc.security;

import me.ubmagh.patientsmvc.security.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration // first type of classes to be instanciated
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    UserDetailsServiceImpl userDetailsServiceImpl;

    @Autowired
    PasswordEncoder passwordEncoder;
    /*
    // causes cyclic depedencies issue :/
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
     */

    // specifies which strategy to authenticate users, DB, memory ...
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        // l:28 // PasswordEncoder passwordEncoder = passwordEncoder();

        // two users in memroy, that have access to the app
        /*
        // no password encoding
        // {noop} ==> no password encoder, cuz when login, the provided password is being hashed and compared with the ones bellow :/
        auth.inMemoryAuthentication().
                withUser("user").password("{noop}12345").roles("USER")
                .and().withUser("admin").password("{noop}12345").roles("USER","ADMIN");
        auth.inMemoryAuthentication().
                withUser("user1").password("{noop}12345").roles("USER");


        // with password encoding
        String encodedPwd = passwordEncoder.encode("12345");
        auth.inMemoryAuthentication().
                withUser("user").password(encodedPwd).roles("USER")
                .and().withUser("admin").password(encodedPwd).roles("USER","ADMIN");
        auth.inMemoryAuthentication().
                withUser("user1").password(encodedPwd).roles("USER");

         */


        // JDBC Authentication
        /*
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("SELECT username as principal, password as credentials,active FROM users WHERE username=?") // oui il faut les rennommer comme ça :/
                .authoritiesByUsernameQuery("SELECT username as principal, role as role FROM users_roles WHERE username=? ")
                .rolePrefix("ROLE_")
                .passwordEncoder( passwordEncoder );
         */

        auth.userDetailsService(userDetailsServiceImpl);
    }


    // spercifies access rights
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);

        // http.formLogin().loginPage("/login"); // specify login page location, custom

        http.formLogin(); // default login page
        http.authorizeRequests().antMatchers("/").permitAll();

        // annotations can be used for the same purpose of next 2 lines
            //when working with JDBC auth
            // http.authorizeRequests().antMatchers("/delete/**","/edit/**", "/save/**", "/new/**", "/put/**").hasRole("ADMIN");
            //         http.authorizeRequests().antMatchers("/index/**").hasRole("USER");
        // when working with s
        http.authorizeRequests().antMatchers("/delete/**","/edit/**", "/save/**", "/new/**", "/put/**").hasAuthority("ADMIN");
        http.authorizeRequests().antMatchers("/index/**").hasAnyAuthority("USER");


        http.authorizeRequests().antMatchers("/webjars/**").permitAll();
        http.authorizeRequests().anyRequest().authenticated(); // it blocks styles (ressources) if l:75 not set
        http.exceptionHandling().accessDeniedPage("/403");
    }
}
