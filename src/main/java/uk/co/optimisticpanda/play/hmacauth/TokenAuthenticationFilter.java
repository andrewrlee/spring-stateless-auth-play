package uk.co.optimisticpanda.play.hmacauth;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

public class TokenAuthenticationFilter extends GenericFilterBean {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {

		// Do real check against request here. Test auth header against encoded request properties.
		if ("yes".equals(request.getParameter("allow"))) {
			SecurityContextHolder.getContext().setAuthentication(new UserAuth("user", "password"));
		}
		
		chain.doFilter(request, response);
	}
}
