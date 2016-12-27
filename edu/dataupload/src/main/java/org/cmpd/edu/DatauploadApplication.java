package org.cmpd.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.cmpd.edu")
@EnableAutoConfiguration
public class DatauploadApplication extends SpringBootServletInitializer {

	private static Class<DatauploadApplication> applicationClass = DatauploadApplication.class;

	public static void main(String[] args) {
		SpringApplication.run(DatauploadApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(applicationClass);
	}
}
