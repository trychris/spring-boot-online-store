//Resources from https://spring.io/guides/gs/securing-web/

package demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/cart", "/checkout").authenticated()
				.anyRequest().permitAll()
				.and()
			.formLogin()
				.loginPage("/login")
				.permitAll()
				.and()
			.logout()
				.permitAll()
				.logoutSuccessUrl("/");

	}

	@Override
//	The Authentication Provider is backed by a simple, in-memory implementation, InMemoryUserDetailsManager. 
//	This is useful for rapid prototyping when a full persistence mechanism is not yet necessary:
	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication()
//			.withUser("user1").password(passwordEncoder().encode("user1Pass")).roles("USER")				
//			.and()
//			.withUser("user2").password(passwordEncoder().encode("user2Pass")).roles("USER")
//			.and()
//			.withUser("admin").password(passwordEncoder().encode("adminPass")).roles("ADMIN");
		auth.userDetailsService(userDetailsService)
			.passwordEncoder(passwordEncoder())
			.and()
			.inMemoryAuthentication()
			.withUser("user1").password(passwordEncoder().encode("user1Pass")).roles("USER")				
			.and()
			.withUser("user2").password(passwordEncoder().encode("user2Pass")).roles("USER")
			.and()
			.withUser("admin").password(passwordEncoder().encode("adminPass")).roles("ADMIN");
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

//	@Bean
//	@Override
//	// sets up an in-memory user store with a single user.
//	// That user is given a user name of user, a password of password, and a role of USER
//	// Meant for testing
//	public UserDetailsService userDetailsService() {
//		UserDetails user = User.withDefaultPasswordEncoder().username("user").password("password").roles("USER")
//				.build();
//
//		return new InMemoryUserDetailsManager(user);
//	}
}
