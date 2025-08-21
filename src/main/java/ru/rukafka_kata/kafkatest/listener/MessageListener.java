package ru.rukafka_kata.kafkatest.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ru.rukafka_kata.kafkatest.dto.PersonDto;
import ru.rukafka_kata.kafkatest.dto.PersonShortDto;


@RequiredArgsConstructor
@Component
public class MessageListener {

    private final ObjectMapper objectMapper;



    @SneakyThrows
    @KafkaListener(topics = "${kafka.consumer.topic.send-message-topic}")
    public void read(String message) {

        PersonShortDto personShortDto = objectMapper.readValue(message, PersonShortDto.class);
        System.out.println("Person input short dto: " + personShortDto.toString());
    }
}
