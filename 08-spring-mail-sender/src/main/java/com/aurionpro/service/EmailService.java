package com.aurionpro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Autowired
	JavaMailSender mailSender;

	public void sendMail(String formEmail, String toEmail, String Subject, String body) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom(formEmail);
		mailMessage.setTo(toEmail);
		mailMessage.setSubject(Subject);
		mailMessage.setText(body);

		
		mailSender.send(mailMessage);
		
		System.out.println("Email send Successfully...!!!");
	}
}
