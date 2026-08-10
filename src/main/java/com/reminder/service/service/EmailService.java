package com.reminder.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	@Autowired
	private JavaMailSender mailSender;
	
	@Value("${spring.mail.username}")
	private String fromEmail;
	
	//Send reminder email
	public void sendReminderEmail(String toEmail, String title, String message) {
		SimpleMailMessage email = new SimpleMailMessage();
		
		email.setFrom(fromEmail);
		email.setTo(toEmail);
		email.setSubject("🔔 Reminder: " + title);
		email.setText("Hello!\n\n"+
				"This is your reminder:\n\n"+
				"📌 Title: " + title + "\n"+
				"💬 Message: " + message + "\n\n" +
				"Have a great day!\n" +
				"Reminder Service !!!!");
		
		mailSender.send(email);
	}
}
