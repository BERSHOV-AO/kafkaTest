package ru.rukafka_kata.kafkatest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.rukafka_kata.kafkatest.service.KafkaProducer;

@RestController
@RequestMapping("api/test")
@RequiredArgsConstructor
public class TestController {

    private final KafkaProducer kafkaProducer;


    @GetMapping("message-kafka")
    public String sendMessageKafka(@RequestParam String message) {

        kafkaProducer.sendMessage(message);
        System.out.println(message);
        return message;
    }


}
