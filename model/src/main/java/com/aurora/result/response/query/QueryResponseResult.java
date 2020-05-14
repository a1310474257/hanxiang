package com.aurora.result.response.query;



import com.aurora.entity.user.User;
import com.aurora.result.QueryResult;
import com.aurora.result.ResultCode;
import com.aurora.result.response.ResponseResult;
import com.aurora.result.resultCodeImpl.CommonCode;
import com.github.pagehelper.PageInfo;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * 查询响应的结果 包含数据集 queryResult和结构代码 resultCode
 */
@ToString
@Data
public class QueryResponseResult<T> extends ResponseResult {
  QueryResult queryResult = new QueryResult();;

  public QueryResponseResult(ResultCode resultCode, QueryResult queryResult) {
    super(resultCode);
    this.queryResult = queryResult;
  }

  /**
   * 封装查询多个
   * @param resultCode
   * @param list
   * @param total
   */
  public  QueryResponseResult(ResultCode resultCode, List<T> list,long total) {
    super(resultCode);
    queryResult.setList(list);
    queryResult.setTotal(total);
  }

  /**
   * 封装一个只查询一个的
   * @param resultCode
   * @param t
   */
  public QueryResponseResult(ResultCode resultCode, T t){
    super(resultCode);
    List<T> list = new ArrayList<>();
    list.add(t);
    queryResult.setList(list);
    queryResult.setTotal(1);
  }


  public QueryResponseResult(ResultCode resultCode, PageInfo<T> pageInfop) {
    super(resultCode);
    List<T> list = pageInfop.getList();
    queryResult.setList(list);
    queryResult.setTotal(pageInfop.getTotal());
  }

}
