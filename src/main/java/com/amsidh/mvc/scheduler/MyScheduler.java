package com.amsidh.mvc.scheduler;

import com.amsidh.mvc.service.MyService;
import lombok.RequiredArgsConstructor;
import org.slf4j.MDC;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

import java.util.UUID;

@Component
@Log4j2
@RequiredArgsConstructor
public class MyScheduler {

    private final MyService myService;

    @Scheduled(fixedDelay = 30 * 1000)
    void greet() {
        MDC.put("X-B3-TraceId", UUID.randomUUID().toString());
        log.info("hello from scheduler");
        myService.display("My name is Amsidh and I am called from scheduler task");
    }

}