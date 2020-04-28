package com.aurora.web.controller;

import com.aurora.api.user.AccountApi;
import com.aurora.entity.account.Account;
import com.aurora.web.service.account.AccountService;
import com.aurora.web.service.security.verification.TokenAuthentication;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
@Api(value = "用户管理接口",description = "提供增删查改")
public class AccountController implements AccountApi {

  @Autowired
  AccountService accountService;

  @Autowired
  private TokenAuthentication tokenAuthentication;

  @ApiImplicitParams({
    @ApiImplicitParam(name="id",value = "用户id",required=true,paramType="path",dataType="int",example = "1"),
    @ApiImplicitParam(name="token",value = "token",required=true,example = "123456"),
    @ApiImplicitParam(name="isUser",value = "0代表用户 1代表管理员",required=true,example = "0"),
  })
  @GetMapping("/findByUserID/{id}")
  @ApiOperation("根据用户id查询账户")
  //@RequestParam(name = "token") String token
  @Override
  public Account findOneByUserId(@PathVariable("id") Integer id ,@RequestParam(name = "token") String token,@RequestParam(name = "isUser") Integer isUser) {
    System.out.println(token);
    boolean validationUser = tokenAuthentication.ValidationUser(id, token);
    System.out.println(validationUser);
    return accountService.findOneByUserId(id);
  }


}
