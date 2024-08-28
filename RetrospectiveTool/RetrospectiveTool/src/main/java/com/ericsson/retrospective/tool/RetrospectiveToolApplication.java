package com.ericsson.retrospective.tool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class RetrospectiveToolApplication {

	public static void main(String[] args) {
		SpringApplication.run(RetrospectiveToolApplication.class, args);
	}

}
