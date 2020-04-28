package com.aurora.common.exception;

import com.aurora.result.ResultCode;
import com.aurora.result.response.ResponseResult;
import com.aurora.result.resultCodeImpl.CommonCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * 异常捕获类
 */

@Slf4j
@ControllerAdvice
public class ExceptionCatch {

  @ExceptionHandler(CommomException.class)
  @ResponseBody
  public ResponseResult customException(CommomException e){
    ResultCode resultCode = e.getResultCode();
    ResponseResult responseResult = new ResponseResult(resultCode);
    return responseResult;
  }

  @ExceptionHandler(Exception.class)
  @ResponseBody
  public ResponseResult SystemException(HttpServletRequest request, Exception e) throws IOException {
    System.out.println(request.getRequestURI()+" "+request.getParameter("a"));
    //获取请求体中的参数
    Map<String, String> parameterByHttpServletRequest = getParameterByHttpServletRequest(request);
    System.out.println(parameterByHttpServletRequest);
    ResponseResult responseResult = new ResponseResult(CommonCode.SYSTEMERROR);
    responseResult.setMessage("未处理异常信息："+e.getMessage());
    e.printStackTrace();
    return responseResult;
  }

  @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
  @ResponseBody
  public ResponseResult HttpRequestMethodNotSupportedException(Exception e) {
    ResponseResult responseResult = new ResponseResult(CommonCode.SYSTEMERROR);
    e.printStackTrace();
    responseResult.setMessage(e.getMessage());
    return responseResult;
  }

  /**
   * 获取参数不存在异常
   * @param e
   * @return
   */
  @ExceptionHandler(MissingServletRequestParameterException.class)
  @ResponseBody
  public ResponseResult MissingServletRequestParameterException(Exception e) {
    log.error(e.getMessage());
    ResponseResult responseResult = new ResponseResult(CommonCode.SYSTEMERROR);
    e.printStackTrace();
    responseResult.setMessage(e.getMessage());
    return responseResult;
  }

  /**
   * 从HttpServletRequest中取参数和值
   * @param request
   * @return
   */
  private Map<String,String> getParameterByHttpServletRequest(HttpServletRequest request){
    Map<String,String> parameterMap = new HashMap<>();
    Enumeration em = request.getParameterNames();
    while (em.hasMoreElements()) {
      String name = (String) em.nextElement();
      parameterMap.put(name,request.getParameter(name));
    }
    return parameterMap;
  }



}
