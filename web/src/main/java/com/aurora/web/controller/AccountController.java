package com.aurora.web.controller;

import com.aurora.api.user.AccountApi;
import com.aurora.common.exception.ExceptionCast;
import com.aurora.entity.account.Account;
import com.aurora.result.response.query.QueryResponseResult;
import com.aurora.result.resultCodeImpl.CommonCode;
import com.aurora.result.resultCodeImpl.SecutiryCode;
import com.aurora.web.service.account.AccountService;
import com.aurora.web.service.log.LogService;
import com.aurora.web.service.security.verification.IPAuthentication;
import com.aurora.web.service.security.verification.TokenAuthentication;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/account")
@Api(value = "账户管理接口",description = "提供增删查改")
public class AccountController implements AccountApi {

  @Autowired
  AccountService accountService;

  @Autowired
  private IPAuthentication ipAuthentication;

  @Autowired
  private TokenAuthentication tokenAuthentication;

  @Autowired
  private LogService logService;

  @ApiImplicitParams({
    @ApiImplicitParam(name="id",value = "用户id",required=true,paramType="path",dataType="int",example = "2"),
    @ApiImplicitParam(name="token",value = "token",required=true,example = "1240"),
    @ApiImplicitParam(name="isUser",value = "0代表用户 1代表管理员",required=true,example = "0"),
  })
  @GetMapping("/findByUserID/{id}")
  @ApiOperation("根据用户id查询账户")
  @Override
  public QueryResponseResult findOneByUserId(@PathVariable("id") Integer id , @RequestParam(name = "token") String token, @RequestParam(name = "isUser") Integer isUser, HttpServletRequest request) {
    //1、验证IP地址是否合法
    boolean authenticationIPAddress = ipAuthentication.AuthenticationIPAddress(request);
    if(!authenticationIPAddress){
      ExceptionCast.CommomException(SecutiryCode.IP_WRONG);
    }
    //2、验证token
    boolean validationAdmin = tokenAuthentication.Validation(id, token, isUser);
    if(!validationAdmin){
      ExceptionCast.CommomException(SecutiryCode.TOKEN_ISNOT_VAILD);
    }
    //3、获取数据  业务
    Account oneByUserId = accountService.findOneByUserId(id);
    QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS,oneByUserId);
    //4、存入日记
    logService.recordInfo(id,  request.getRequestURI());
    return queryResponseResult;
  }


}
