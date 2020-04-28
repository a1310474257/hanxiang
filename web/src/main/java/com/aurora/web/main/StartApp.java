package com.aurora.web.main;

import com.aurora.common.exception.ExceptionCast;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication(scanBasePackages = "com.aurora")
@MapperScan("com.aurora.web.dao")
public class StartApp {
  public static void main(String[] args) {
    SpringApplication.run(StartApp.class,args);
  }


}


