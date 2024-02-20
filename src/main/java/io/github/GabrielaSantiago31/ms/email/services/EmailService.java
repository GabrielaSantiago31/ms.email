package io.github.GabrielaSantiago31.ms.email.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import io.github.GabrielaSantiago31.ms.email.enums.EmailStatus;
import io.github.GabrielaSantiago31.ms.email.models.Email;
import io.github.GabrielaSantiago31.ms.email.repositories.EmailRepository;

@Service
public class EmailService {
	
	@Autowired
	private EmailRepository emailRepository;
	
	@Autowired
	private JavaMailSender sender;

	@SuppressWarnings("finally")
	public Email sendEmail(Email email) {
		email.setDateTime(LocalDateTime.now());
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom(email.getMailFrom());
			message.setTo(email.getMailTo());
			message.setSubject(email.getSubject());
			message.setText(email.getText());
			sender.send(message);
			
			email.setStatus(EmailStatus.SENT);
			
		}catch(MailException e) {
			email.setStatus(EmailStatus.ERROR);
		}finally {
			return emailRepository.save(email);
		}
		
	}
	
	
}
