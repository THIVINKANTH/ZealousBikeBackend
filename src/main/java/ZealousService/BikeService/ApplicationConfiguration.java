package ZealousService.BikeService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.bind.annotation.CrossOrigin;

@Configuration
@EnableWebSecurity
public class ApplicationConfiguration 
{
	@Bean
	public PasswordEncoder encoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public InMemoryUserDetailsManager uservalues()
	{
		UserDetails user1=User.withUsername("Thivin")
							.password(encoder().encode("1234"))
							.roles("User").build();
		return new InMemoryUserDetailsManager(user1);
	}
	
	@Bean
	public SecurityFilterChain safety(HttpSecurity hp) throws Exception
	{
		hp
		.authorizeRequests()
		.antMatchers("/mybikeproject")
		.authenticated();
		hp.csrf().disable();
		hp.cors();
		hp.formLogin();
		hp.httpBasic();
		
		return hp.build();
	}
}
