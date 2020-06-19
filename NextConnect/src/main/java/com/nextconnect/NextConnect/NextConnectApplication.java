package com.nextconnect.NextConnect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.nextconnect")
@ComponentScan("com.nextconnect")
@EntityScan("com.nextconnect")
public class NextConnectApplication {

	public static void main(String[] args) {
		SpringApplication.run(NextConnectApplication.class, args);
	}

}
