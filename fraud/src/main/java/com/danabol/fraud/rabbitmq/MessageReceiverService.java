package com.danabol.fraud.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MessageReceiverService {

//    @RabbitListener(queues = "fraud1")
    public void receiveMessage(String message) {
        // Обработка полученного сообщения
        System.out.println("Received message: " + message);
    }

}
