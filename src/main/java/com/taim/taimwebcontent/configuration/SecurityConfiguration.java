//package com.taim.content.configuration;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//    @Override
//    public void configure(WebSecurity webSecurity) throws Exception {
//        webSecurity.ignoring().antMatchers("/resources/**", "/static/**");
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().antMatchers("/**").permitAll();
//    }
//}
