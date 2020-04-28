package com.aurira.test.api;

import com.aurora.entity.account.Account;
import com.aurora.web.main.StartApp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = StartApp.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class testRequest {
  private RestTemplate  restTemplate = new RestTemplate();
  @Test
  public void test(){
    Account account = this.restTemplate.getForObject("http://127.0.0.1:9999/hanxiang/account/findByUserID/2?token=111", Account.class);
    System.out.println(account);
  }
}
