package uk.co.optimisticpanda.play.hmacauth;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	private static final Logger L = LoggerFactory.getLogger(WebSecurityConfig.class);
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		     .sessionManagement().sessionCreationPolicy(STATELESS)
		.and()
		    .authorizeRequests()
				.antMatchers("/favicon.ico").permitAll()
		        .anyRequest().fullyAuthenticated()
		.and()
			.exceptionHandling()
				.authenticationEntryPoint(send401AccessDeniedEntryPoint())
		.and()
		  .addFilterBefore(new TokenAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
	}

	public AuthenticationEntryPoint send401AccessDeniedEntryPoint() {
	    return (request, response, authException) -> {
	        L.debug("AA Pre-authenticated entry point called. Rejecting access");
	        response.setContentType("application/json");
	        response.setStatus(401);
	        response.getOutputStream().println("{ \"error\": \"" + authException.getMessage() + "\" }");
	    };
	}
}