package com.aurora.common.exception;


import com.aurora.result.ResultCode;

/**
 * 异常抛出类
 */
public class ExceptionCast {

  /**
   * 抛出我的异常
   * @param resultCode
   */
  public static void CommomException(ResultCode resultCode){
    throw  new CommomException(resultCode);
  }


}
