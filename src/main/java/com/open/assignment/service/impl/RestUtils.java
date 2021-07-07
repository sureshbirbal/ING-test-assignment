package com.open.assignment.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestUtils {

    final String url = "http://localhost:8080/";

    RestTemplate restTemplate = new RestTemplate();
    ObjectMapper objectMapper = new ObjectMapper();
    String endPoint;
    public <T> Object getData(String path, String id, Class<?> clz) throws JsonProcessingException {
        endPoint = url + path +"/"+id;
        ResponseEntity<String> response
                = restTemplate.getForEntity(endPoint.toString(), String.class);
        return objectMapper.readValue(response.getBody(), clz);
    }
}
