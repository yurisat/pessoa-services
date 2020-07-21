package com.desafio.pessoaservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	/**
	 * Spring Boot allows configuring Content Negotiation using properties
	 */
	@Override
	public void configureContentNegotiation(final ContentNegotiationConfigurer configurer) {
		configurer.favorParameter(true)
			.parameterName("mediaType")
			.ignoreAcceptHeader(false)
			.useRegisteredExtensionsOnly(false)
			.defaultContentType(MediaType.APPLICATION_JSON);
	}
}
