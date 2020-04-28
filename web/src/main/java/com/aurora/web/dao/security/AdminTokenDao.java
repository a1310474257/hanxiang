package com.aurora.web.dao.security;

import com.aurora.entity.security.AdminToken;
import org.apache.ibatis.annotations.Select;

public interface AdminTokenDao {

  @Select("select id,token,start_time,end_time,vaild_size from security_admintoken where py_admin_id = #{adminId}")
  public AdminToken findOneByAdminId(Integer adminId);
}
