package com.example.Findingnumbergame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@SpringBootApplication
public class Emailsendercls {
@Autowired
JavaMailSender messager;
void sender(String to, String sub, String body) {
	SimpleMailMessage sm=new SimpleMailMessage();
	sm.setFrom("abiramijavadev@gmail.com");
	sm.setTo(to);
	sm.setText(body);
	sm.setSubject(sub);
	messager.send(sm);
	System.out.println("email sended..");
	
}
}
