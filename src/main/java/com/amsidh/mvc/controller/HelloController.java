package com.amsidh.mvc.controller;

import com.amsidh.mvc.service.MyService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class HelloController {

    private final MyService myService;
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


    @GetMapping("/hello/demo")
    public String demoServiceCall() {
        log.info("Calling Demo Service");
        myService.callDemoService();
        return "Sync Hello World operation completed";
    }
}


