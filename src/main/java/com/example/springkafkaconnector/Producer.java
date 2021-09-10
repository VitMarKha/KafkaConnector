package com.example.springkafkaconnector;

import org.apache.kafka.clients.admin.NewTopic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class Producer {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public void sendMessage(String message) {
        byte[] barr = Base64.getDecoder().decode(message);
        this.kafkaTemplate.send(Controller.TOPIC, new String(barr));
    }

    @Bean
    public NewTopic createTopic() {
        return new NewTopic(Controller.TOPIC,3,(short) 1);
    }
}
