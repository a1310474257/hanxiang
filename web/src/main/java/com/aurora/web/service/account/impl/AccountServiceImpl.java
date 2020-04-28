package com.aurora.web.service.account.impl;

import com.aurora.entity.account.Account;
import com.aurora.web.dao.account.AccountDao;
import com.aurora.web.service.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

  @Autowired
  AccountDao accountDao;
  @Override
  public Account findOneByUserId(Integer userId) {
    return accountDao.findOneByUserId(userId);
  }
}
