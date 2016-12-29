package org.cmpd.edu.upload;

import org.cmpd.edu.core.service.mongo.AssessmentUploadServiceMongo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@ComponentScan(basePackages = "org.cmpd.edu")
@EnableAutoConfiguration
@EnableMongoRepositories(basePackages = "org.cmpd.edu")
@Import(value = {AssessmentUploadServiceMongo.class})
public class Application extends SpringBootServletInitializer {

	private static Class<Application> applicationClass = Application.class;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(applicationClass);
	}
}
