package ru.rukafka_kata.kafkatest.service;

import ru.rukafka_kata.kafkatest.dto.PersonDto;

import java.time.Period;

public interface KafkaProducer {
    void sendMessage(String message);
    void sendMessage(PersonDto personDto);
}
