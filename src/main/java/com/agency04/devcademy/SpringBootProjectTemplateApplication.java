package com.agency04.devcademy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import javax.sql.DataSource;

@SpringBootApplication
public class SpringBootProjectTemplateApplication {


	public static void main(String[] args) {
		SpringApplication.run(SpringBootProjectTemplateApplication.class, args);
	}

}
