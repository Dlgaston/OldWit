package com.app.config;



import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages="com.app.repository")
@EntityScan(basePackages="com.app.entity")
public class ApplicationConfig {

}
