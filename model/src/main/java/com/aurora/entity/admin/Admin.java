package com.aurora.entity.admin;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@ToString
@Data
public class Admin {
  private Integer id;
  private String account_number;
  private String password;
  private String name;
  private Integer is_update;
  private String role;
  private Date create_time;
  private Date update_time;
}
