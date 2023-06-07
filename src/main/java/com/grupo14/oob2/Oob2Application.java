package com.grupo14.oob2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

// Se cambio @SpringBootApplication por lo de abajo, sino no me corria.
@SpringBootApplication
public class Oob2Application {

	public static void main(String[] args) {
		SpringApplication.run(Oob2Application.class, args);
	}

}
