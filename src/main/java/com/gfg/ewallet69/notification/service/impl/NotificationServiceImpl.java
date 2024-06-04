package com.gfg.ewallet69.notification.service.impl;

import com.gfg.ewallet69.notification.service.MailContentUtil;
import com.gfg.ewallet69.notification.service.NotificationService;
import com.gfg.ewallet69.notification.service.resource.NotificationRequest;
import com.gfg.ewallet69.notification.service.resource.UserResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    RestTemplate template;

    @Autowired
    JavaMailSender mailSender;

    @Override
    public void sendCommunication(NotificationRequest notificationRequest) {


        if(notificationRequest.getTransactionStatus().equalsIgnoreCase("SUCCESS") && notificationRequest.getUserType().equalsIgnoreCase("SENDER")){
            UserResponse response=template.getForEntity("http://localhost:8081/user/"+notificationRequest.getUserId(),UserResponse.class).getBody();
            SimpleMailMessage message=new SimpleMailMessage();
            message.setSubject(MailContentUtil.getSubjectTransactionSuccessful());
            message.setText(MailContentUtil.getSuccessSenderEmailContent(response.getName(),notificationRequest.getAmount()));
            message.setTo(response.getEmail());
            mailSender.send(message);
        }
        if(notificationRequest.getTransactionStatus().equalsIgnoreCase("SUCCESS") && notificationRequest.getUserType().equalsIgnoreCase("RECEIVER")){
            UserResponse response=template.getForEntity("http://localhost:8081/user/"+notificationRequest.getUserId(),UserResponse.class).getBody();
            SimpleMailMessage message=new SimpleMailMessage();
            message.setSubject(MailContentUtil.getSubjectTransactionSuccessful());
            message.setText(MailContentUtil.getSuccessReceiverEmailContent(response.getName(),notificationRequest.getAmount()));
            message.setTo(response.getEmail());
            mailSender.send(message);
        }
        if(notificationRequest.getTransactionStatus().equalsIgnoreCase("FAILURE") && notificationRequest.getUserType().equalsIgnoreCase("SENDER")){
            UserResponse response=template.getForEntity("http://localhost:8081/user/"+notificationRequest.getUserId(),UserResponse.class).getBody();
            SimpleMailMessage message=new SimpleMailMessage();
            message.setSubject(MailContentUtil.getSubjectTransactionFailure());
            message.setText(MailContentUtil.getFailureEmailContent(response.getName(),notificationRequest.getAmount()));
            message.setTo(response.getEmail());
            mailSender.send(message);
        }
    }






}

