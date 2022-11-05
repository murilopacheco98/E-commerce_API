package com.ecommerce.educative;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
//@EnableJpaRepositories(basePackages = "com.ecommerce.educative.repository")

public class EducativeApplication extends SpringBootServletInitializer {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(EducativeApplication.class, args);
	}

	public void run(String... args) throws Exception {
		String sql = "INSERT INTO category (id, category_name, description,  image_url) VALUES ("
				+ "78, 'descrição','72', 'imagem aqui')";

		int rows = jdbcTemplate.update(sql);
		if (rows > 0) {
			System.out.println("A new row has been inserted.");
		}
	}
}
