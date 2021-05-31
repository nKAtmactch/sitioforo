package com.dwa.foro;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
		.authorizeRequests()
			.antMatchers(//ruta con acceso libre
						"/",
						"/css/**",
						"/js/**",
						"/usuario/**",
						"/usuario/validar"
					).permitAll()
			.anyRequest().authenticated()//cualquier otra ruta es ocn el token
			.and()
		.formLogin()
			.loginPage("/usuario/validar")//esta ruta se usa valdar el usuario
			.successForwardUrl("/usuario/validar")
			.permitAll()
			.and()
		.logout()
			.permitAll(); 
		 
			
	}
}
