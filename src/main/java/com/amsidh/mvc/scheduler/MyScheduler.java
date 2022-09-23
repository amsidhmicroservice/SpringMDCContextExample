package com.amsidh.mvc.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class MyScheduler {

    @Scheduled(fixedDelay = 4 * 1000)
    void greet() {
        log.info("hello from scheduler");
    }

}