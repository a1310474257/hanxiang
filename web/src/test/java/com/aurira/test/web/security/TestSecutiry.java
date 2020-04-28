package com.aurira.test.web.security;

import com.aurora.util.RSAUtils;
import com.aurora.web.main.StartApp;
import com.aurora.web.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = StartApp.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
public class TestSecutiry {
  @Value("${aurora.hanxiang.security.server.public_key}")
  private String serverPublicKey;
  @Value("${aurora.hanxiang.security.server.private_key}")
  private String serverPrivateKey;
  @Value("${aurora.hanxiang.security.client.public_key}")
  private String clientPublicKey;
  @Value("${aurora.hanxiang.security.client.private_key}")
  private String clientPrivateKey;
  @Autowired
  private UserService userService;

  /**
   * 测试rsa加密和解密   加签和验签名
   */
  @Test
  public void testEncryptionAndDecrypt() throws Exception {
    //1 加密和解密
    // RSA加密
    log.error("adadasds");
    log.warn("汪汪汪");
//    String data = "service";
//    String encryptData = RSAUtils.encrypt(data, RSAUtils.getPublicKey(this.serverPublicKey));
//    System.out.println("service加密后内容:" + encryptData);
//    // RSA解密
//    String decryptData = RSAUtils.decrypt(encryptData, RSAUtils.getPrivateKey(this.serverPrivateKey));
//    System.out.println("service加密后内容解密后内容:" + decryptData);
//
//    String data2 = "client";
//    String encryptData2 = RSAUtils.encrypt(data, RSAUtils.getPublicKey(this.clientPublicKey));
//    System.out.println("client加密后内容:" + encryptData2);
//    // RSA解密
//    String decryptData2 = RSAUtils.decrypt(encryptData2, RSAUtils.getPrivateKey(this.clientPrivateKey));
//    System.out.println("client解密后内容:" + decryptData2);

    }
}
