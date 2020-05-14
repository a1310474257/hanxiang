package com.aurora.web.service.log;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class LogService {

    public  void recordInfo(Integer id,String apiName){
        log.info("用户id为："+id.toString()+"----->使用了"+apiName+"接口");
    }
    public  void recordInfo(Integer id,String apiName,Integer isUser){
        //是管理员
        if (isUser==1){
            log.info("管理员id为："+id.toString()+"----->使用了"+apiName+"接口");
        }
        //是用户
        if(isUser==0){
            recordInfo(id,apiName);
        }
    }
    public  void recordInfo(Integer id,String apiName,Integer isUser,Integer isUpdate){
        recordInfo(id,apiName,isUser);
        //记录到数据库
    }
}
