package org.arpit.java2blog;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringBootAngularJSApplication {

	public static void main(String[] args) 
	{
		SpringApplication.run(SpringBootAngularJSApplication.class, args);   
	}
}