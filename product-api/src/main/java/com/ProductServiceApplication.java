package com;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/***
 * 
 * Spring Boot Main class to start the tomcat inside docker and provide all REST
 * end points Required to scan all packages in order to start properly
 *
 */

@SpringBootApplication
@ComponentScan({ "com.controller","com.service","com.error" })
@EntityScan("com.entity")
@EnableJpaRepositories("com.repository")
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}
}
