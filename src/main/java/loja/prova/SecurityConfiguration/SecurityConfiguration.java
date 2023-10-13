package loja.prova.SecurityConfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	
	@Autowired
	private UserDetailsService uds;
	
	@Bean
	AuthenticationProvider autenticationProvider() {
		DaoAuthenticationProvider prov = new DaoAuthenticationProvider();
		
		prov.setUserDetailsService(uds);
		prov.setPasswordEncoder(new BCryptPasswordEncoder());
	
		return prov;
	}
	
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		return http.authorizeHttpRequests(
				authorizeConfig ->{
					authorizeConfig.requestMatchers("/login").permitAll();
					authorizeConfig.requestMatchers("/produto", "/tags").hasAuthority("admin");
					authorizeConfig.requestMatchers("/").permitAll();
//					authorizeConfig.requestMatchers("/marca/{id}").permitAll();
					authorizeConfig.anyRequest().authenticated();
				})
				.formLogin(form  -> form.loginPage("/login").defaultSuccessUrl("/marca"))
				.logout(logout -> logout.logoutSuccessUrl("/"))
				.build();
		
	}
	@Bean
	public WebSecurityCustomizer webSecurityCostumizer () throws Exception{
		return (web) -> web.ignoring().requestMatchers("/img/**","/js/**","/css/**","/vendor/**");
	}

}
