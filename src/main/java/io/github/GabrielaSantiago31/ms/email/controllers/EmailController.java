package io.github.GabrielaSantiago31.ms.email.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.github.GabrielaSantiago31.ms.email.dtos.EmailDto;
import io.github.GabrielaSantiago31.ms.email.models.Email;
import io.github.GabrielaSantiago31.ms.email.services.EmailService;
import jakarta.validation.Valid;

@RestController
public class EmailController {
	
	@Autowired
	public EmailService emailService;
	
	@PostMapping("/email-sending")
	public ResponseEntity<Email> sendingEmail(@RequestBody @Valid EmailDto emailDto) throws InterruptedException{
		Email email = new Email();
		BeanUtils.copyProperties(emailDto, email);
		emailService.sendEmail(email);
		return new ResponseEntity<>(email, HttpStatus.CREATED);
	}
}
