package com.amsidh.mvc.service.impl;

import com.amsidh.mvc.service.MyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
@RequiredArgsConstructor
public class MyServiceImpl implements MyService {

    private final RestTemplate restTemplate;

    @Value("${demo.service.url:http://springdemo:8080/health}")
    private String demoServiceUrl;

    @Override
    public void display(String message) {
        log.info("Message from MyServiceImpl {}", message);
        callDemoService();
    }

    @Override
    public void callDemoService() {
        log.info("Calling URL {}", demoServiceUrl);
        String response = restTemplate.getForObject(demoServiceUrl, String.class);
        log.info("Response received from Demo Service {}", response);
    }
}
