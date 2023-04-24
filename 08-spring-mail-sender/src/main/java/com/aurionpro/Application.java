package com.aurionpro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.aurionpro.service.EmailService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);
	
		EmailService emailService = run.getBean(EmailService.class);
		emailService.sendMail("amoghbiniwale04@gmail.com", "jyotibiniwale@gmail.com", "Sending mail using Spring boot", "this is 1st attempt to send an email from spring boot");
	}

}
