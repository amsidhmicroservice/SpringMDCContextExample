package com.amsidh.mvc;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@Slf4j
@RequiredArgsConstructor
@EnableScheduling
@EnableAsync
public class SpringMdcContextExampleApplication {

    public static void main(String[] args) {
        MDC.put("Principal", "Amsidh");
        SpringApplication.run(SpringMdcContextExampleApplication.class, args);
    }
}
