package com.aurora.api.user;

import com.aurora.entity.user.User;
import com.aurora.result.response.query.QueryResponseResult;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Api(value = "用户管理接口",description = "提供增删查改")
public interface UserApi {
  /**
   * 查询所有用户
   * @return
   */
  public QueryResponseResult finAll(String token, Integer adminId, HttpServletRequest request, int pageNumber, int pageSize);

}
