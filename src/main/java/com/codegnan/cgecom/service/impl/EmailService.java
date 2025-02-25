package com.codegnan.cgecom.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender mailSender;

	public void sendEmail(String to, String subject, String body) {

		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper;
		try {
			System.out.println("***************************In email service");

			helper = new MimeMessageHelper(message, true);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(body, true); // true means HTML is allowed in the body

			mailSender.send(message);
			System.out.println("***************************Message sent");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("***************************Message not sent");
			e.printStackTrace();

			// Rethrow as a RuntimeException to ensure transaction rollback
			throw new RuntimeException("Failed to send email to " + to, e);
		}
	}
}
