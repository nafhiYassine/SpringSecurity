package com.example.expert;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.expert.Rest.RestApi;
import com.example.expert.Rest.models.AppRoles;
import com.example.expert.Rest.models.Personne;
import com.example.expert.Rest.services.PersonneImp;


@SpringBootApplication

@ComponentScan(basePackageClasses = RestApi.class)
@EnableJpaRepositories(basePackages = "com.example.expert.Rest.respo")
public class ExpertApplication {
	
	public static void main(String[] args) {
		
		SpringApplication.run(ExpertApplication.class, args);
		System.out.println("ecommerce project");
	}
	
	@Bean
	PasswordEncoder passwordEncoder(){
		return new  BCryptPasswordEncoder();
	}

	@Bean 
	CommandLineRunner start(PersonneImp personneService){
		return args->{
			
			personneService.save(new Personne("yassine","nafhi","yasisne",24,12000,new ArrayList<>()));
			personneService.save(new Personne("mounir","nafhi","yassine1",30,20000,new ArrayList<>()));
			personneService.save(new Personne("anas","nafhi","uassoen1",22,1000,new ArrayList<>()));
			personneService.saveRoles(new AppRoles("admin"));
			personneService.saveRoles(new AppRoles("user"));
			personneService.AddRolesToUser( "yassine","admin");
			personneService.AddRolesToUser( "mounir","user");


		};
		
	}
}
