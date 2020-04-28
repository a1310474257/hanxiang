package com.aurora.config;

import com.github.pagehelper.PageHelper;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * 分页插件配置
 *
 * 增加dialect属性，使用时必须指定该属性，可选值为oracle,mysql,mariadb,sqlite,hsqldb,postgresql,没有默认值，必须指定该属性。
 * 增加offsetAsPageNum属性，默认值为false，使用默认值时不需要增加该配置，需要设为true时，需要配置该参数。当该参数设置为true时，使用RowBounds分页时，会将offset参数当成pageNum使用，可以用页码和页面大小两个参数进行分页。
 * 增加rowBoundsWithCount属性，默认值为false，使用默认值时不需要增加该配置，需要设为true时，需要配置该参数。当该参数设置为true时，使用RowBounds分页会进行count查询。
 * 增加pageSizeZero属性，默认值为false，使用默认值时不需要增加该配置，需要设为true时，需要配置该参数。当该参数设置为true时，如果pageSize=0或者RowBounds.limit = 0就会查询出全部的结果（相当于没有执行分页查询，但是返回结果仍然是Page类型）。
 * 增加reasonable属性，默认值为false，使用默认值时不需要增加该配置，需要设为true时，需要配置该参数。具体作用请看上面配置文件中的注释内容。启用合理化时，如果pageNum<1会查询第一页，如果pageNum>pages会查询最后一页 ,禁用合理化时，如果pageNum<1或pageNum>pages会返回空数据
 */
@Configuration
public class PageHelperConfig {
  @Bean
  public PageHelper pageHelper(){
    PageHelper pageHelper = new PageHelper();
    Properties p = new Properties();
    p.setProperty("dialect", "mysql");
    p.setProperty("offsetAsPageNum","true");
    p.setProperty("rowBoundsWithCount","true");
    p.setProperty("reasonable","true");
    pageHelper.setProperties(p);
    return pageHelper;
  }
}
