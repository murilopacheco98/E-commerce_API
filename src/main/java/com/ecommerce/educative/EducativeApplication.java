package com.ecommerce.educative;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//@EnableSwagger2
//@Configuration
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})

public class EducativeApplication {
	public static void main(String[] args) {
		SpringApplication.run(EducativeApplication.class, args);
	}
}
