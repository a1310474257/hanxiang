package com.aurora.web.dao.security;

import com.aurora.entity.security.UserToken;
import org.apache.ibatis.annotations.Select;

public interface UserTokenDao {

  @Select("select id,token,start_time,end_time,vaild_size,create_time,update_time from security_usertoken where py_user_id = #{userId} ")
  public UserToken findOneByUserId(Integer id);
}
