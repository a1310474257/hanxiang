package com.aurora.web.dao.user;



import com.aurora.entity.account.Account;
import com.aurora.entity.user.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao {

  /**
   * 查询所有用户
   * @return
   */
  @Results({
    @Result(id=true,property = "id",column = "id"),
    @Result(property = "account_number",column = "account_number"),
    @Result(property = "phonenumber",column = "phonenumber"),
    @Result(property = "birthday",column = "birthday"),
    @Result(property = "password",column = "password"),
    @Result(property = "imageurl",column = "imageurl"),
    @Result(property = "name",column = "name"),
    @Result(property = "nickname",column = "nickname"),
    @Result(property = "openid",column = "openid"),
    @Result(property = "account",column = "id",javaType = Account.class,one = @One(select = "com.aurora.web.dao.account.AccountDao.findOneByUserId"))
  })
  @Select("select id,account_number,phonenumber,birthday,password,imageurl,name,nickname,openid from user_user")
  public List<User> finAll();

}
