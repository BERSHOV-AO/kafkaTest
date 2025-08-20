package ru.rukafka_kata.kafkatest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducerImpl implements KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Value("${kafka.producer.topic.send-message-topic}")
    private String topicName;

    @Override
    public void sendMessage(String message) {
        kafkaTemplate.send(topicName, message);
    }
}
