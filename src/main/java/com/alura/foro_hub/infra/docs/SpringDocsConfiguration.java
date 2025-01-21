package com.alura.foro_hub.infra.docs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SpringDocsConfiguration {

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.components(new Components().addSecuritySchemes("bearer-key",
						new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer")
								.bearerFormat("JWT")))
				.info(new Info().title("Foro_Hub API").description(
						"Foro_Hub API Rest application, it has topics and comments CRUD functionalities.")
						.contact(new Contact().name("Backend Team").email("backend@foro.hub"))
						.license(new License().name("Apache 2.0").url("http://foro.hub/api/license")));
	}
}
