package com.example.springkafkaconnector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @RequestMapping(value ="/publish", method = RequestMethod.GET)
    public String produceKafkaMessage() {
        kafkaTemplate.send("cdcpg-topic",
                "This message is coming from Producer - Hello Kafka");
        return "Message succcessfully Produced to Kafka";
    }

    @KafkaListener(topics = "cdcpg-topic", groupId = "group_id")
    public void kafkaListener1(String message) {
        System.out.println("Message received from Producer to Consumer");
        System.out.println(message);
    }
}
