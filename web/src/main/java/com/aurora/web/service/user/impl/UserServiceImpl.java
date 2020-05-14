package com.aurora.web.service.user.impl;

import com.aurora.entity.user.User;
import com.aurora.web.dao.account.AccountDao;
import com.aurora.web.dao.user.UserDao;
import com.aurora.web.service.user.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserDao userDao;



   /**
   * 查询所有用户
   * @return
   */
  @Override
  public PageInfo<User> finAll(int pageNumber,int pageSize) {
    //设置分页信息(第几页，每页数量)
    PageHelper.startPage(pageNumber, pageSize);
    //取记录总条数
    //查询要放在设置分页信息后面才有效
    List<User> users = userDao.finAll();
    PageInfo<User> userPageInfo = new PageInfo<>(users);
    return userPageInfo;
  }

  /**
   * 根据id查找用户
   * @param id
   * @return
   */
  @Override
  public User findOneById(Integer id) {
    return userDao.findOneById(id);
  }


}
