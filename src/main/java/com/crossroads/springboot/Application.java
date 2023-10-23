package com.crossroads.springboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

import java.util.logging.Logger;

@Slf4j

@SpringBootApplication
@ComponentScan(basePackages = "com.crossroads.springboot")
public class Application {

	public static void main(String[] args) {
		log.debug("*********CROSSROADS**************");
		SpringApplication.run(Application.class, args);
	}

}
