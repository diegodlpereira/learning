package com.dlpereira.springsecuritydemo.configuration;

import com.dlpereira.springsecuritydemo.filter.AuditLogFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

@Configuration
@EnableWebSecurity(debug = true)
public class MultipleSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Order(1)
    @Configuration
    public static class UserConfig extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {

            http.antMatcher("/user/**").authorizeRequests().antMatchers("/user/**").permitAll()
                    .and().sessionManagement().disable()
                    .cors().disable()
                    .csrf().disable()
                    .logout().disable()
                    .requestCache().disable()
                    .headers().disable();
        }
    }

    @Order(2)
    @Configuration
    public static class AdminConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.antMatcher("/admin/**").authorizeRequests().antMatchers("/admin/**").permitAll()
                    .and().addFilterAfter(new AuditLogFilter(), FilterSecurityInterceptor.class);
        }
    }

}
