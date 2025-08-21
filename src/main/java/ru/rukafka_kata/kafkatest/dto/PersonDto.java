package ru.rukafka_kata.kafkatest.dto;

import lombok.*;

@Builder
public record PersonDto(String name,
                        String surname,
                        int age,
                        String city,
                        String country,
                        String car,
                        String work,
                        double salary) {}

