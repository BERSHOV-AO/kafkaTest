package ru.rukafka_kata.kafkatest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.rukafka_kata.kafkatest.dto.PersonDto;
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

    @PostMapping("message-kafka-dto")
    public String messagePersonDto(@RequestParam String name,
                                   @RequestParam String surname,
                                   @RequestParam int age,
                                   @RequestParam String city,
                                   @RequestParam String country,
                                   @RequestParam String car,
                                   @RequestParam String work,
                                   @RequestParam double salary) {

        PersonDto personDto = PersonDto.builder().name(name).surname(surname).age(age).
                city(city).country(country).car(car).work(work).salary(salary).build();

        kafkaProducer.sendMessage(personDto);
        System.out.println(personDto.toString());
        return "OK";
    }


}
