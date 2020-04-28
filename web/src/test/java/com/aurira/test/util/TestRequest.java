package com.aurira.test.util;

import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

public class TestRequest {



    @Test
    public void testRestTemplate(){
        RestTemplate restTemplate =  new RestTemplate(new OkHttp3ClientHttpRequestFactory());
        ResponseEntity<Map> forEntity = restTemplate.getForEntity("http://127.0.0.1:9999/hanxiang/user/findAll", Map.class);
        Map body = forEntity.getBody();
        System.out.println(body.get(body));
    }

}
