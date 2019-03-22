package com.akushwah.example.democors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class WebConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.addFilterAfter(corsFilter(), BasicAuthenticationFilter.class);
	}

	@Bean(name="corsFilterDC")
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		// limit to the web dev server address
		config.addAllowedOrigin("http://localhost:8080");
		config.addAllowedHeader("*");
		config.addAllowedMethod(HttpMethod.GET);
		config.addAllowedMethod(HttpMethod.POST);
		config.addAllowedMethod(HttpMethod.PUT);
		config.addAllowedMethod(HttpMethod.PATCH);
		config.addAllowedMethod(HttpMethod.DELETE);
		config.addAllowedMethod(HttpMethod.HEAD);
		config.addAllowedMethod(HttpMethod.TRACE);
		config.addAllowedMethod(HttpMethod.OPTIONS);
		// config.setExposedHeaders(Arrays.asList("Aakash"));
		config.addExposedHeader("Aakash1");
		// Angular 2 special requirement:
		// EVERY response, even Error 500, must have the CORS headers attached.
		// If the server doesn't attach the CORS headers to the Error response
		// then the XHR Object won't parse it, thus the XHR Object won't have
		// any response body, status, or any other response data inside
		source.registerCorsConfiguration("/info/home", config);
		
		CorsConfiguration config1 = new CorsConfiguration();
		config.setAllowCredentials(true);
		// limit to the web dev server address
		config1.addAllowedOrigin("http://localhost:8080");
		config1.addAllowedHeader("*");
		// config.setExposedHeaders(Arrays.asList("Aakash"));
		config1.addExposedHeader("Aakash2");
		// Angular 2 special requirement:
		// EVERY response, even Error 500, must have the CORS headers attached.
		// If the server doesn't attach the CORS headers to the Error response
		// then the XHR Object won't parse it, thus the XHR Object won't have
		// any response body, status, or any other response data inside
		source.registerCorsConfiguration("/info/get", config1);
		return new CorsFilter(source);
	}
}