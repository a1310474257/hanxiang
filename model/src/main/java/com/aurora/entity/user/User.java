package com.aurora.entity.user;

import com.aurora.entity.account.Account;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class User {
  private Integer id;
  private String openid;
  private String account_number;
  private String phonenumber;
  private Date birthday;
  private String password;
  private String imageurl;
  private String name;
  private String nickname;
  private Account account;
  private Date create_time;
  private Date update_time;

}
