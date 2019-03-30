package com.react.springboot.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@ComponentScan("com.react.springboot.poc.model")
//@ComponentScan("com.react.springboot.poc.web")
@ComponentScan
@EnableJpaRepositories
@EntityScan
public class ReactSpingbootPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactSpingbootPocApplication.class, args);
	}

}
