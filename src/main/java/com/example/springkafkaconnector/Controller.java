package com.example.springkafkaconnector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    public static final String TOPIC = "testTopic";
    public static final String GROUPID = "group_id";

    private final Producer producer;

    @Autowired
    public Controller(Producer producer) {
        this.producer = producer;
    }

    @GetMapping ("/publish")
    public void messageToTopic(@RequestParam("message") String message) {
        this.producer.sendMessage(message);
    }
}
