package com.example.springkafkaconnector;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    @KafkaListener(topics = Controller.TOPIC, groupId = Controller.GROUPID)
    public void consumeMessage(String message) {
        System.out.println(message);
    }
}
