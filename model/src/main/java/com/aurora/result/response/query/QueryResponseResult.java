package com.aurora.result.response.query;



import com.aurora.result.QueryResult;
import com.aurora.result.ResultCode;
import com.aurora.result.response.ResponseResult;
import com.aurora.result.resultCodeImpl.CommonCode;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * 查询响应的结果 包含数据集 queryResult和结构代码 resultCode
 */
@ToString
@Data
public class QueryResponseResult<T> extends ResponseResult {
  QueryResult queryResult;

  public QueryResponseResult(ResultCode resultCode, QueryResult queryResult) {
    super(resultCode);
    this.queryResult = queryResult;
  }

  public  QueryResponseResult(ResultCode resultCode, List<T> list,long total) {
    super(resultCode);
    queryResult = new QueryResult();
    queryResult.setList(list);
    queryResult.setTotal(total);
  }

}
