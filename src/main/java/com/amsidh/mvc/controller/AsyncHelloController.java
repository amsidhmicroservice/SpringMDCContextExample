package com.amsidh.mvc.controller;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class AsyncHelloController {

    @SneakyThrows
    @Async
    @GetMapping("/hello/async")
    public String asyncHello() {
        for (int i = 0; i < 10; i++) {
            log.info("Async Counter {}", i);
            Thread.sleep(1000);
        }
        return "Async Hello World operation completed";
    }
}
