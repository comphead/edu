package org.cmpd.edu.view;

import org.cmpd.edu.core.service.mongo.AssessmentViewServiceMongo;
import org.cmpd.edu.core.service.mongo.StaticDataViewServiceMongo;
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
@EnableMongoRepositories(basePackages = "org.cmpd.edu.core.repository.mongo")
@Import(value = {AssessmentViewServiceMongo.class, StaticDataViewServiceMongo.class})
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
