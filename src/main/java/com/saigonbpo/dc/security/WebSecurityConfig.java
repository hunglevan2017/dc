package com.saigonbpo.dc.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.saigonbpo.dc.Controller.HomeCtrl;
import com.saigonbpo.dc.Service.UserService;
import com.saigonbpo.dc.Service.Impl.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{


	
    @Autowired
    UserDetailsServiceImpl userDetailsService;
    
	Logger logger = LoggerFactory.getLogger(WebSecurityConfig.class);
 
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }
     
     
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception { 
 
        // Setting Service to find User in the database.
        // And Setting PassswordEncoder
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());     
 
    }
 
 	/**/
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	
   
        http.csrf().disable();
 
        // The pages does not require login
        http.authorizeRequests().antMatchers("/", "/login", "/logout").permitAll();
        
        http.authorizeRequests().antMatchers("/api/**","/masterdata/**").permitAll();
        
        http.authorizeRequests().antMatchers(
                "/",
                "/js/**",
                "/css/**",
                "/img/**",
                "/webjars/**").permitAll();
 


        http.authorizeRequests().antMatchers("/admin/**","/role/**")
        .access("hasAnyRole('ROLE_SUPERVISOR', 'ROLE_SUBADMIN', 'ROLE_ADMIN','ROLE_TEAMLEAD')");
 
        
        
        // When the user has logged in as XX.
        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");
        
        
 
        // Config for Login Form
        http.authorizeRequests().and().formLogin()//
                // Submit URL of login page.
                .loginProcessingUrl("/j_spring_security_check") // Submit URL
                .loginPage("/login")//
                .defaultSuccessUrl("/homepage")//
                .failureUrl("/login?error=true")//
                .usernameParameter("username")//
                .passwordParameter("password")
                // Config for Logout Page
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/logoutSuccessful");
    }
    		
    

}
