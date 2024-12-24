//package com.example.FawryTask;
//
//import io.swagger.v3.oas.annotations.OpenAPIDefinition;
//import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
//import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
//import io.swagger.v3.oas.annotations.info.Info;
//import io.swagger.v3.oas.annotations.security.SecurityScheme;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//
//@SpringBootApplication
//@ComponentScan
//@EnableJpaRepositories
//@SecurityScheme(
//		name = "bearerAuth",
//		scheme = "bearer",
//		bearerFormat = "JWT",
//		type = SecuritySchemeType.HTTP,
//		in = SecuritySchemeIn.HEADER
//)
//@OpenAPIDefinition(info = @Info(title = "Library APIs", version = "1", description = "Library Management Apis."))
//public class FawryTaskApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(FawryTaskApplication.class, args);
//	}
//
//}
