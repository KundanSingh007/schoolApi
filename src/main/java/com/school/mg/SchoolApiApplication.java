package com.school.mg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@OpenAPIDefinition(

		/*
		 * tags = {
		 * 
		 * @Tag(name="widget", description="Widget operations."),
		 * 
		 * @Tag(name="gasket", description="Operations related to CONSPROM") },
		 */

		info = @Info(title = "DU-API-JUNE-2023", version = "2.0.1", contact = @Contact(name = "Api for UniversityofDelhi", url = "http://test.com/contact", email = "test@test.com"), license = @License(name = "DU 2.0", url = "test.com")))
public class SchoolApiApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SchoolApiApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SchoolApiApplication.class);
	}

}
