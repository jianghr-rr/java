package com.example.spiringbootstart.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
//@Component
public class BootSchedule {
    private final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm:ss");

    @Scheduled(fixedRate = 3000)
    public void schedule1() {
        log.info("shceduler1 -> {}", LocalDateTime.now().format((fmt)));
    }

    @Scheduled(fixedDelay = 3000)
    public void schedule2() {
        log.info("shceduler2 -> {}", LocalDateTime.now().format((fmt)));
    }

    @Scheduled(initialDelay = 2000, fixedRate = 3000)
    public void schedule3() {
        log.info("shceduler3 -> {}", LocalDateTime.now().format((fmt)));
    }

    @Scheduled(cron = "*/3 * * * * ?")
    public void schedule4() {
        log.info("shceduler4 -> {}", LocalDateTime.now().format((fmt)));
    }
}
