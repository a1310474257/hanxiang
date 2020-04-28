package com.aurora.web.service.user;

import com.aurora.entity.user.User;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface UserService {
  public PageInfo<User> finAll(int pageNumber, int pageSize);
}
