package com.example.spiringbootstart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SpiringbootStartApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpiringbootStartApplication.class, args);
    }

}
