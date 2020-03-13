package com.sayedLabs.spring.springboot.controller;

import com.sayedLabs.spring.springboot.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.xml.ws.Response;
import java.util.Arrays;
import java.util.List;

@RestController
public class ProductConsumer {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/consume/products")
    public String consumeProducts(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        return restTemplate.exchange("http://localhost:8080/products", HttpMethod.GET,new HttpEntity<String>(headers),String.class).getBody();
    }
}
