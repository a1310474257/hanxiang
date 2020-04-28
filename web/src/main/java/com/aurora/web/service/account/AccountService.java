package com.aurora.web.service.account;

import com.aurora.entity.account.Account;


public interface AccountService {
  /**
   * 根据用户id查找账户
   * @param userId
   * @return
   */
  public Account findOneByUserId(Integer userId);
}
