package com.facturio.demo;

import com.facturio.demo.entities.AppUser;
import com.facturio.demo.entities.enums.Role;
import com.facturio.demo.repositories.UserRepository;
import com.facturio.demo.services.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class UserServiceApplication {
/*	@Bean
	DiscoveryClientRouteDefinitionLocator dynamicRoutes(ReactiveDiscoveryClient rdc, DiscoveryLocatorProperties dlp) {
		return new DiscoveryClientRouteDefinitionLocator(rdc, dlp);
	}*/

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	@Autowired
	private UserServiceInterface service;

	@Bean
	CommandLineRunner start(UserRepository userRepository) {
		return args -> {
			service.AddUser(new AppUser( 0, "Julien", "pwd", "julien@test.fr" ,Role.ADMIN));
		};
	}
}
