package com.customerapplication.customerbooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan("com.customerapplication.customerbooking")
public class CustomerbookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerbookingApplication.class, args);
	}

	@EnableSwagger2
	public class SpringbootSwaggerConfig {
		@Bean
		public Docket productApi() {
			return new Docket(DocumentationType.SWAGGER_2).select()
					.apis(RequestHandlerSelectors.basePackage("com.customerapplication.customerbooking")).build();

		}
	}
}
