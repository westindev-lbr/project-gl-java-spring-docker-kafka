package com.fil.sra.service.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ServiceConfig {
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
