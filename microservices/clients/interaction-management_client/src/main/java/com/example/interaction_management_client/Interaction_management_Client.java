package com.example.interaction_management_client;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.awt.*;
import java.io.IOException;

@Controller
public class Interaction_management_Client {

    @Autowired
    private DiscoveryClient discoveryClient;

    public void getEmployee() throws RestClientException, IOException {

        List<ServiceInstance> instances = discoveryClient.getInstances("Interaction_management");

        ServiceInstance serviceInstance=instances.get(0);
        String baseUrl=serviceInstance.getUri().toString();
        baseUrl=baseUrl+"/event/all";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response=null;
        try{
            response=restTemplate.exchange(baseUrl,
                    HttpMethod.GET, getHeaders(),String.class);
        }catch (Exception ex)
        {
            System.out.println(ex);
        }
        System.out.println(response.getBody());
    }
    private static HttpEntity<?> getHeaders() throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", PageAttributes.MediaType.APPLICATION_JSON_VALUE);
        return new HttpEntity<>(headers);
    }













}
