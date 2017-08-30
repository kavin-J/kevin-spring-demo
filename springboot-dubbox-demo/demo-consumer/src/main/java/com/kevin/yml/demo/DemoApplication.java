package com.kevin.yml.demo;

import com.kevin.yml.demo.service.ConsumerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(DemoApplication.class, args);
		ConsumerService service = run.getBean(ConsumerService.class);
		System.err.println("consumer:"+service.getName());
	}


}
