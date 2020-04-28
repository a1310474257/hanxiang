package com.aurora.entity.account;


import com.aurora.entity.user.User;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class Account {
  private int id;
  private double balance;
  private double total_consuption;
  private double total_recharge;
  private int pk_user_id;
  private User user;
  private Date create_time;
  private Date update_time;
}
