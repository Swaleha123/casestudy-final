package com.cts.project.config;

import org.springframework.beans.factory.annotation.Autowired;

/*
	import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;*/

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
 



	@Configuration
	@EnableWebSecurity
	public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	/*	
		@Autowired
		ServiceConfig serviceConfig;
		
		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception
		{
			System.out.println(serviceConfig.getUsername()+":"+serviceConfig.getPassword());
			auth.inMemoryAuthentication()
			.withUser(serviceConfig.getUsername()).password("{noop}"+serviceConfig.getPassword()).authorities("ROLE_ADMIN");
		}
		
		@Override
		protected void configure(HttpSecurity http) throws Exception
		{
			http
			.cors().and()
			.csrf().disable()
			.authorizeRequests()
			.anyRequest().authenticated()
			.and().httpBasic();
		}*/
		 
		/* @Bean
		  UrlBasedCorsConfigurationSource corsConfigurationSource() {
		    CorsConfiguration configuration = new CorsConfiguration();
		    configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
		    configuration.setAllowedMethods(Arrays.asList("GET","POST"));
		    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		    source.registerCorsConfiguration("/**", configuration);
		    return source;
	}*/
		   @Override
		    protected void configure(HttpSecurity http) throws Exception {
		        http.addFilterBefore(new CorsFilter(), ChannelProcessingFilter.class);
		        http
		                .authorizeRequests()
		                .antMatchers("/")
		                .permitAll()
		                .anyRequest()
		                .fullyAuthenticated()
		                .and()
		                .httpBasic()
		                .and().csrf().disable();
		    }

	}
