package com.aurora.web.service.security.verification;

import com.aurora.entity.security.AdminToken;
import com.aurora.entity.security.UserToken;
import com.aurora.web.dao.security.AdminTokenDao;
import com.aurora.web.dao.security.UserTokenDao;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 权限验证
 */
@Service
public class TokenAuthentication{
  @Autowired
  private UserTokenDao userTokenDao;

  @Autowired
  private AdminTokenDao adminTokenDao;

  /**
   * 验证用户token
   * @param userId
   * @param token
   * @return
   */
  public boolean ValidationUser(Integer userId,String token){
    if(userId==null){
      return false;
    }
    if(token==null||StringUtils.isEmpty(token)){
      return false;
    }
    if(userId!=null&& StringUtils.isNotEmpty(token)){
      UserToken userToken = userTokenDao.findOneByUserId(userId);
      if(userToken==null){
        return false;
      }
      if(userToken.getToken().equals(token)){
        //验证token是否过期
        return true;
      }
      return false;
    }
    return false;
  }

  /**
   * 验证管理员token
   * @param adminId
   * @param token
   * @return
   */
  public boolean ValidationAdmin(Integer adminId,String token){
    if(adminId==null){
      return false;
    }
    if(token==null||StringUtils.isEmpty(token)){
      return false;
    }
    if(adminId!=null&& StringUtils.isNotEmpty(token)){
      AdminToken adminToken = adminTokenDao.findOneByAdminId(adminId);
      if(adminToken==null){
        return false;
      }
      //主要核心
      if (adminToken.getToken().equals(token)){
        //验证token是否过期
        return true;
      }
      return false;
    }

    return  false;
  }

  /**
   * 验证token
   * @param id
   * @param token
   * @param isUser
   * @return
   */
  public boolean Validation(Integer id ,String token,Integer isUser){
    if(isUser==null){
      return false;
    }
    //是管理员
    if (isUser==1){
      return ValidationAdmin(id,token);
    }
    //是用户
    if(isUser==0){
      return ValidationUser(id,token);
    }
    return false;
  }
}
