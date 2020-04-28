package com.aurora.web.service.security.verification;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * 参数校验类
 */
@Service
public class IPAuthentication {

  /**
   * 验证ip地址是否呗授权
   * @return
   */
  public boolean AuthenticationIPAddress(HttpServletRequest request) {
    String ip = getIp(request);
    if(ip==null||ip.equals("")){
        return false;
      }
      if(ip.equals("127.0.0.1")){
        return true;
      }
      return false;
  }

  /**
   * 获取ip地址
   * @param request
   * @return
   */
   private String getIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if(StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)){
           //多次反向代理后会有多个ip值，第一个ip才是真实ip
           int index = ip.indexOf(",");
           if(index != -1){
              return ip.substring(0,index);
          }else{
              return ip;
                    }
        }
        ip = request.getHeader("X-Real-IP");
        if(StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)){
              return ip;
        }
            return request.getRemoteAddr();
         }

}
