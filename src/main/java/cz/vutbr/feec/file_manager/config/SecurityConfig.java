package cz.vutbr.feec.file_manager.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests()
					.antMatchers("/css/**", "/").permitAll()
					.antMatchers("/user/**").hasRole("USER")
					.and()
				.formLogin().loginPage("/login").failureUrl("/login-error").defaultSuccessUrl("/user/index");
	}
	
	@SuppressWarnings("deprecation")
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.inMemoryAuthentication()
				.withUser(User.withDefaultPasswordEncoder().username("user").password("user").roles("USER"));
		auth
			.inMemoryAuthentication()
				.withUser(User.withDefaultPasswordEncoder().username("admin").password("admin").roles("ADMIN"));
	}
}
