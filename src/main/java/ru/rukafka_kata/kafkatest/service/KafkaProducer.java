package ru.rukafka_kata.kafkatest.service;

public interface KafkaProducer {
    void sendMessage(String message);
}
