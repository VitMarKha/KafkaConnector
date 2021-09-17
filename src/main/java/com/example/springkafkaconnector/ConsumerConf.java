package com.example.springkafkaconnector;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.ApplicationArguments;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

@Configuration
@EnableKafka
public class ConsumerConf {

    @Bean
    public ConsumerFactory<String, String> consumerFactory(ApplicationArguments args) {
        Map<String, Object> consumerconfigProperties = new HashMap<>();
        consumerconfigProperties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, args.getNonOptionArgs().get(2));
        consumerconfigProperties.put(ConsumerConfig.GROUP_ID_CONFIG, args.getNonOptionArgs().get(1));
        consumerconfigProperties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        consumerconfigProperties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        return new DefaultKafkaConsumerFactory<>(consumerconfigProperties);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory(ApplicationArguments args) {
        ConcurrentKafkaListenerContainerFactory<String, String> kafkaFactory = new ConcurrentKafkaListenerContainerFactory<>();
        kafkaFactory.setConsumerFactory(consumerFactory(args));
        return kafkaFactory;
    }

}
