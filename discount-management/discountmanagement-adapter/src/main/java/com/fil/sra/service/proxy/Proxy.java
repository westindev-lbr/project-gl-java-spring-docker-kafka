package com.fil.sra.service.proxy;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;


public class Proxy {

    private final RestTemplate rest;

    public Proxy(RestTemplate rest){
        this.rest = rest;
    }

    public <T> T getTemplate(String url,Class<T> responseType){
        ResponseEntity<T> response = rest.exchange(
                url,
                HttpMethod.GET,
                null,
                responseType);
        return response.getBody();
    }

    public <T> T getParametizeTemplateList(String url, Type responseType){
        RestTemplate rest = new RestTemplate();
        ResponseEntity<T> response = rest.exchange(
                url,
                HttpMethod.GET,
                null,
                ParameterizedTypeReference.forType(responseType)
        );
        return response.getBody();
    }


    public <T> T editTemplate(String url,Class<T> responseType,T obj,HttpMethod meth){
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
        //ResponseEntity<Void> response =
        rest.exchange(
                url,
                HttpMethod.DELETE,
                null,
                Void.class);
    }
}
