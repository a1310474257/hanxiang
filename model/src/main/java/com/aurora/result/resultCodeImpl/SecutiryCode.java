package com.aurora.result.resultCodeImpl;

import com.aurora.result.ResultCode;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class SecutiryCode extends CommonCode {
  public static SecutiryCode IP_WRONG = new SecutiryCode(false,11000,"IP错误！");
  public static SecutiryCode TOKEN_ISNOT_VAILD = new SecutiryCode(false,11001,"token失效或者错误！");
  public static SecutiryCode TOKEN_IS_NULL = new SecutiryCode(false,11002,"token不能为空！");
  public static SecutiryCode ID_IS_NULL = new SecutiryCode(false,11003,"id不能为空！");
  public SecutiryCode(boolean success, int code, String message) {
    super(success,code,message);
  }


}
