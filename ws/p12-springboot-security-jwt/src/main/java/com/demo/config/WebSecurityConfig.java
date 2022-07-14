package com.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.demo.filters.JwtRequestFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

	@Autowired
	private UserDetailsService jwtUserDetailsService;

	@Autowired
	private JwtRequestFilter jwtRequestFilter;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

		// auth.inMemoryAuthentication()
		// auth.ldapAuthentication()
		// auth.jdbcAuthentication()

		auth.userDetailsService(jwtUserDetailsService);
	}

	// updated-> new
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
	    return authenticationConfiguration.getAuthenticationManager();
	}
	
	

	// updated-> new
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		// We don't need CSRF for this example
		
		httpSecurity
		.cors().and()  // Once you introduce Spring Security, you need to register CORS with your security configuration.
		.csrf().disable()
				// dont authenticate this particular request

		.authorizeRequests()
		.antMatchers("/authenticate", "/api/demo/greet/**").permitAll()
//		.antMatchers("/all/**").access("hasAnyRole('MANAGER','ADMIN')")
		.antMatchers("/api/demo/user/**").access("hasRole('USER')")
		.antMatchers("/api/demo/admin/**").access("hasRole('ADMIN')")
		
				// all other requests need to be authenticated
				.anyRequest().authenticated().and().
				// make sure we use stateless session; session won't be used to
				// store user's state.
				exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		// Add a filter to validate the tokens with every request
		httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
		
		return httpSecurity.build();
	}
	
	 @Bean
	    public WebSecurityCustomizer webSecurityCustomizer() {
	        return (web) -> web.ignoring().antMatchers("/images/**", "/js/**", "/webjars/**");
	    }
}