package com.amsidh.mvc.controller;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloController {

    @SneakyThrows
    @GetMapping("/hello/sync")
    public String helloWorld() {
        for (int i = 0; i < 10; i++) {
            log.info("Sync Counter {}", i);
            Thread.sleep(1000);
        }
        return "Sync Hello World operation completed";
    }

    @PostMapping(value = "/hello", consumes = MediaType.TEXT_PLAIN_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    public String sayHelloWithName(@RequestBody String name) {
        return "Hello " + name;
    }
}
