package com.gfg.ewallet69.notification.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {

    @Bean
    public JavaMailSender createMailSender(){

        JavaMailSenderImpl mailSender=new JavaMailSenderImpl();

        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(465);
        mailSender.setUsername("ewallet69");
        mailSender.setPassword("qfpc udnc yxlu zcsd");
        return mailSender;
    }
}
