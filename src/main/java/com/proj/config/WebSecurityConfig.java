package com.proj.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsUtils;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig  extends WebSecurityConfigurerAdapter {
	
	 @Autowired
	    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

	    @Autowired
	    private UserDetailsService jwtUserDetailsService;

	    @Autowired
	    private JwtRequestFilter jwtRequestFilter;

	    @Autowired
	    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	        // configure AuthenticationManager so that it knows from where to load
	        // user for matching credentials
	        // Use BCryptPasswordEncoder
	        auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder());
	}

	    @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }

	    @Bean
	    @Override
	    public AuthenticationManager authenticationManagerBean() throws Exception {
	        return super.authenticationManagerBean();
	    }

	    @Override
	    protected void configure(HttpSecurity httpSecurity) throws Exception {
	    	System.out.println("#################cors 커버");
	        // For CORS error
	        httpSecurity.cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues());
	        // We don't need CSRF for this example
	        httpSecurity.csrf().disable()
	            // dont authenticate this particular request
	            //.authorizeRequests().antMatchers("/","/home","/board","/task","/member","/authenticate").permitAll().
	        	.authorizeRequests().antMatchers("/**").permitAll(). //이정주 수정
	        	// all other requests need to be authenticated
	               // anyRequest().authenticated(). //이정주 주석처리
	                and().
	            
	            // stateless session 
	            // authenticationEntryPoint(jwtAuthenticationEntryPoint): 인증 실패시 처리할거
	                exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
	            .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

	        // Add a filter to validate the tokens with every request
	        httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	    }
}	
