package com.aurora.web.controller;

import com.aurora.api.user.UserApi;
import com.aurora.common.exception.ExceptionCast;
import com.aurora.entity.user.User;
import com.aurora.result.QueryResult;
import com.aurora.result.ResultCode;
import com.aurora.result.response.query.QueryResponseResult;
import com.aurora.result.resultCodeImpl.CommonCode;
import com.aurora.result.resultCodeImpl.SecutiryCode;
import com.aurora.web.service.log.LogService;
import com.aurora.web.service.security.verification.IPAuthentication;
import com.aurora.web.service.security.verification.TokenAuthentication;
import com.aurora.web.service.user.UserService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@RestController
@RequestMapping("/user")
@Api(value = "用户管理接口",description = "提供增删查改")
public class UserController implements UserApi {


  @Autowired
  private UserService userService;

  @Autowired
  private IPAuthentication ipAuthentication;

  @Autowired
  private TokenAuthentication tokenAuthentication;

  @Autowired
  private LogService logService;

  @ApiImplicitParams({
    @ApiImplicitParam(name="adminId",value = "管理员id",required=true,example = "1"),
    @ApiImplicitParam(name="token",value = "token",required=true,example = "11231"),
    @ApiImplicitParam(name="pageNumber",value = "页码数",required=true,example = "1"),
    @ApiImplicitParam(name="pageSize",value = "页面大小",required=true,example = "2"),
  })
  @Override
  @ApiOperation("查询所有用户")
  @GetMapping("/findAll")
  public QueryResponseResult finAll(@RequestParam("token") String token, @RequestParam("adminId") Integer adminId, HttpServletRequest request, @RequestParam("pageNumber") int pageNumber, @RequestParam("pageSize") int pageSize) {
    //1、验证IP地址是否合法
    boolean authenticationIPAddress = ipAuthentication.AuthenticationIPAddress(request);
    if(!authenticationIPAddress){
      ExceptionCast.CommomException(SecutiryCode.IP_WRONG);
    }
    //2、验证token
    boolean validationAdmin = tokenAuthentication.ValidationAdmin(adminId, token);
    if(!validationAdmin){
      ExceptionCast.CommomException(SecutiryCode.TOKEN_ISNOT_VAILD);
    }
    //3、获取数据
    PageInfo<User> userPageInfo = userService.finAll(pageNumber,pageSize);
    if(userPageInfo==null){
      ExceptionCast.CommomException(CommonCode.RESULT_IS_NULL);
    }
    QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS,userPageInfo);
    //4、存入日记

    return queryResponseResult;
  }

  @ApiImplicitParams({
          @ApiImplicitParam(name="token",value = "token",required=true,example = "11231"),
          @ApiImplicitParam(name="userId",value = "用户id",required=true,example = "2"),
  })
  @ApiOperation("根据id查询用户")
  @GetMapping("/findOneById")
  @Override
  public QueryResponseResult findOneById(@RequestParam("token") String token, @RequestParam("userId") Integer userId, HttpServletRequest request, HttpServletResponse response) {
    //1、验证IP地址是否合法
    boolean authenticationIPAddress = ipAuthentication.AuthenticationIPAddress(request);
    if(!authenticationIPAddress){
      ExceptionCast.CommomException(SecutiryCode.IP_WRONG);
    }
    //2、验证token
    boolean validationAdmin = tokenAuthentication.ValidationUser(userId, token);
    if(!validationAdmin){
      ExceptionCast.CommomException(SecutiryCode.TOKEN_ISNOT_VAILD);
    }
    //3、获取数据
    User oneById = userService.findOneById(userId);
    if(oneById==null){
      ExceptionCast.CommomException(CommonCode.RESULT_IS_NULL);
    }
    QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS,oneById);
    //4、存入日记
    logService.recordInfo(userId, "findOneById");
    return queryResponseResult;
  }


}
