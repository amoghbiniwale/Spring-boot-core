package com.aurionpro.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements EmailService{
	
	@Value("${spring.mail.username}")
	private String fromEmail;
	
	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public String sendMail(MultipartFile[] file, String to, String[] cc, String subject, String body) {
	try {
		
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
		
		mimeMessageHelper.setFrom(fromEmail);
		mimeMessageHelper.setTo(to);
		mimeMessageHelper.setCc(cc);
		mimeMessageHelper.setSubject(subject);
		mimeMessageHelper.setText(body);
		
		javaMailSender.send(mimeMessage);
		
		
	}catch(Exception e) {
		throw new RuntimeException(e);
	}
		
		return "Mail send successfully";
	}

}
