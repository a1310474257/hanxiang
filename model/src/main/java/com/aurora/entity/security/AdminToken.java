package com.aurora.entity.security;

import lombok.Data;
import lombok.ToString;

import java.util.Date;
@Data
@ToString
public class AdminToken {
  private Integer id;
  private String token;
  private Date start_time;
  private Date end_time;
  private Integer vaild_size;
  private Integer py_admin_id;
  private Date create_time;
  private Date update_time;
}
