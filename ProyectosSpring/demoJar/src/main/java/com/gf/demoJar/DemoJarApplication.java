package com.gf.demoJar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.gf.demoJar.DemoJarApplication;

@SpringBootApplication
public class DemoJarApplication extends SpringBootServletInitializer {
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(DemoJarApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoJarApplication.class, args);
	}

}
