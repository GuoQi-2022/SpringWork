package com.example.springdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication(scanBasePackages = { "com.*" })
@Slf4j
public class Application {

    public static void main(String[] args) throws Exception {
        try {
            SpringApplication.run(Application.class, args);
        } catch (Exception e) { // e.printStackTrace(); // }
            SpringApplication.run(Application.class, args);
        }
    }
}
