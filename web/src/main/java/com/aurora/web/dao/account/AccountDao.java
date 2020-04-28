package com.aurora.web.dao.account;

import com.aurora.entity.account.Account;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface AccountDao {

  /**
   * 根据用户id查找账户
   * @param userId
   * @return
   */
  @Results({
    @Result(id=true,property = "id",column = "id"),
    @Result(property = "total_consuption",column = "total_consuption"),
    @Result(property = "balance",column = "balance"),
    @Result(property = "total_recharge",column = "total_recharge"),
    @Result(property = "pk_user_id",column = "pk_user_id"),
  })
  @Select("select id,total_consuption,balance,total_recharge,pk_user_id from account_account where pk_user_id = #{userId}")
  public Account findOneByUserId(Integer userId);
}
