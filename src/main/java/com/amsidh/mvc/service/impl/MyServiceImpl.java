package com.amsidh.mvc.service.impl;

import com.amsidh.mvc.service.MyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
@RequiredArgsConstructor
public class MyServiceImpl implements MyService {

    private final RestTemplate restTemplate;

    @Override
    public void display(String message) {
        log.info("Message from MyServiceImpl {}", message);
        callDemoService();
    }

    @Override
    public void callDemoService() {
        String response = restTemplate.getForObject("http://localhost:8484/health", String.class);
        log.info("Response received from Demo Service {}", response);
    }
}
