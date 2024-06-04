package com.gfg.ewallet69.notification.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gfg.ewallet69.notification.service.NotificationService;
import com.gfg.ewallet69.notification.service.resource.NotificationRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationConsumer {

    @Autowired
    NotificationService notificationService;

    ObjectMapper mapper=new ObjectMapper();

    Logger logger= LoggerFactory.getLogger(NotificationConsumer.class);

    @KafkaListener(topics = "notification-topic", groupId = "notificationGrp")
    public void consume(String message) {
        logger.info("Consumed message: " + message);
        try {
            NotificationRequest notificationRequest = mapper.readValue(message, NotificationRequest.class);
            notificationService.sendCommunication(notificationRequest);
        }catch (Exception ex){
            logger.error("exception while reading notification content");
        }
    }
}
