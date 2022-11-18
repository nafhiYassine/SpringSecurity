package com.example.expert.Rest.em;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;
@Component
public class EmailSender {
	private static final String domaineEmail = "ecommerce_project@domaine.org";

	@Autowired
	private EmailConfig emailConfig;

        public void sendSimpleMessage() {

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost(this.emailConfig.getHost());
		mailSender.setPort(this.emailConfig.getPort());
		mailSender.setUsername(this.emailConfig.getUsername());
		mailSender.setPassword(this.emailConfig.getPassword());
			try {
				SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setFrom(domaineEmail);
			mailMessage.setTo("nafhiyassine11@gmail.com");
			mailMessage.setSubject("New feedback from " + "yassine");
			mailMessage.setText("JUST TYPING");
			mailSender.send(mailMessage);
			System.out.println("bravoooo");
			} catch (Exception e) {
				e.getMessage();
			}
        }

	

	
}