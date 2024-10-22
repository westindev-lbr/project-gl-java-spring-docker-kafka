package com.fil.sra.service.config.proxy;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class Proxy {

    public <T> T getTemplate(String url,Class<T> responseType){
        RestTemplate rest = new RestTemplate();
        ResponseEntity<T> response = rest.exchange(
                url,
                HttpMethod.GET,
                null,
                responseType);
        return response.getBody();
    }

    public <T> T getParametizeTemplate(String url){
        RestTemplate rest = new RestTemplate();
        ResponseEntity<T> response = rest.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<T>() {});
        return response.getBody();
    }

    public <T> T editTemplate(String url,Class<T> responseType,T obj,HttpMethod meth){
        RestTemplate rest = new RestTemplate();
        HttpEntity<T> request = new HttpEntity<T>(obj);
        ResponseEntity<T> response = rest.exchange(
                url,
                meth,
                request,
                responseType);
        return response.getBody();
    }

    public <T> T postTemplate(String url,Class<T> responseType,T obj){
        return this.editTemplate(url, responseType, obj,HttpMethod.POST);
    }
    public <T> T putTemplate(String url,Class<T> responseType,T obj){
        return this.editTemplate(url, responseType, obj,HttpMethod.PUT);
    }

    public void deleteTemplate(String url){
        RestTemplate rest = new RestTemplate();
        //ResponseEntity<Void> response =
        rest.exchange(
                url,
                HttpMethod.DELETE,
                null,
                Void.class);
    }
}
