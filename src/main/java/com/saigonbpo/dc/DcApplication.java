package com.saigonbpo.dc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@ImportResource( { "classpath*:spring-config.xml"} )
@PropertySource("classpath:jdbc.properties")
public class DcApplication {

	public static void main(String[] args) {
		SpringApplication.run(DcApplication.class, args);
	}
}
