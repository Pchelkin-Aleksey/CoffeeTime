package com.example.coffee_time;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class CoffeeTimeApplication{
    public static void main(String[] args) {
        SpringApplication.run(CoffeeTimeApplication.class, args);
    }

}
