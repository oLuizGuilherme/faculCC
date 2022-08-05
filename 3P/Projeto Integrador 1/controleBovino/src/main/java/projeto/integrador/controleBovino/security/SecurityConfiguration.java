package projeto.integrador.controleBovino.security;

import java.util.List;

import javax.servlet.Filter;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration implements SecurityFilterChain, WebSecurityCustomizer {

	@Override
	public void customize(WebSecurity web) {
		web.con
	}

	@Override
	public boolean matches(HttpServletRequest request) {
		request.
		return false;
	}

	@Override
	public List<Filter> getFilters() {
		return null;
	}


	

}
