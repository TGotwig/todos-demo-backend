package com.example.todosdemobackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication(exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
@EnableSwagger2
public class TodosDemoBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodosDemoBackendApplication.class, args);
	}

	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/api/**"))
				.build()
				.apiInfo(apiDetails());
	}

	private ApiInfo apiDetails() {
		String css = "<style>" +
				"#model-TodoContent {display: none !important}" +
				"</style>";

		return new ApiInfo(
				"Todos Demo API",
				"My awesome todos API \uD83D\uDD75" + css,
				"1.0",
				null,
				new Contact(
						"Thomas Gotwig",
						"https://tgotwig.github.io/tgotwig",
						"tgotwig@gmail.com"),
				null,
				null,
				Collections.emptyList()
		);
	}

}
