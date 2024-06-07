package com.gfg.ewallet69.notification.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {

    @Bean
    public JavaMailSender createMailSender(){

        JavaMailSenderImpl mailSender=new  JavaMailSenderImpl();

        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername("<gmail_address>");
        mailSender.setPassword("<APP password>");
        mailSender.getJavaMailProperties().setProperty("mail.smtp.starttls.enable", "true");
        mailSender.getJavaMailProperties().setProperty("mail.smtp.auth", "true");
        return mailSender;
    }
}
