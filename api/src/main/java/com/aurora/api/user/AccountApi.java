package com.aurora.api.user;

import com.aurora.entity.account.Account;
import io.swagger.annotations.Api;

@Api(value = "账户管理接口",description = "提供增删查改")
public interface AccountApi {
  /**
   * 根据用户id查找账户
   * @param Id
   * @return
   */
  public Account findOneByUserId(Integer Id ,String token,Integer isUser);

}
