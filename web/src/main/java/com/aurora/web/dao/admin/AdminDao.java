package com.aurora.web.dao.admin;

import com.aurora.entity.admin.Admin;
import org.apache.ibatis.annotations.Select;

public interface AdminDao {

  /**
   * 根据id查找管理员用户
   * @return
   */
  @Select("select id,account_number,password,name,is_update,role")
  public Admin findOneById(Integer adminId);

}
