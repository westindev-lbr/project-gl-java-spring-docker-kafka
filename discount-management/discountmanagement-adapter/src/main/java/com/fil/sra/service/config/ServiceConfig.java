package com.fil.sra.service.config;

import com.fil.sra.service.proxy.ProductProxy;
import com.fil.sra.service.proxy.Proxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;

@Configuration
@PropertySource(value = "classpath:webservice.properties")
public class ServiceConfig {
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
    @Bean
    public Proxy getProxy(RestTemplate restTemplate){
        return new ProductProxy(restTemplate);
    }
}
