package com.example.thi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.example")
@SpringBootApplication
public class ThiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThiApplication.class, args);
    }

}
