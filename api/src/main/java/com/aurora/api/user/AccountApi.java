package com.aurora.api.user;

import com.aurora.entity.account.Account;
import com.aurora.result.response.query.QueryResponseResult;
import io.swagger.annotations.Api;

import javax.servlet.http.HttpServletRequest;

@Api(value = "账户管理接口",description = "提供增删查改")
public interface AccountApi {
  /**
   * 根据用户id查找账户
   * @param Id
   * @return
   */
  public QueryResponseResult findOneByUserId(Integer Id , String token, Integer isUser, HttpServletRequest request);

}
