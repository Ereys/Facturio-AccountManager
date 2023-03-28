package com.facturio.demo;

import com.facturio.demo.entities.User;
import com.facturio.demo.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UserserviceApplication {


	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(UserRepository userRepository) {
		return args -> {
			userRepository.save(new User( 0, "Julien"));



		};
	}

}
