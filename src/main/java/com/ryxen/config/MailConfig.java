package com.ryxen.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.ryxen.constant.Constant;

@Configuration
public class MailConfig {
	 @Bean
	    public JavaMailSender getJavaMailSender() {
	        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	        //config host
	        mailSender.setHost("smtp.gmail.com");
	        //config port
	        mailSender.setPort(587);
	        
	        //set username
	        mailSender.setUsername(Constant.MY_EMAIL);
	        //setpassword
	        mailSender.setPassword(Constant.MY_PASSWORD);
	        
	        //create object property
	        Properties props = mailSender.getJavaMailProperties();
	        //put transport là một giao thức mạng để chuyển tập tin, video, âm thanh qua mạng IP
	        props.put("mail.transport.protocol", "smtp");
	        //put auth
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.starttls.enable", "true");
	        //put debug
	        props.put("mail.debug", "true");
	 
	        return mailSender;
	    }
}
