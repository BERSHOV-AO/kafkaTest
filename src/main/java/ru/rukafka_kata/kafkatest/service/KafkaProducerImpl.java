package ru.rukafka_kata.kafkatest.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.rukafka_kata.kafkatest.dto.PersonDto;

@Service
@RequiredArgsConstructor
public class KafkaProducerImpl implements KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    @Value("${kafka.producer.topic.send-message-topic}")
    private String topicName;

    @Override
    public void sendMessage(String message) {
        kafkaTemplate.send(topicName, message);
    }

    @SneakyThrows
    @Override
    public void sendMessage(PersonDto personDto) {
        String strDto = objectMapper.writeValueAsString(personDto);
        kafkaTemplate.send(topicName, strDto);
    }
}
