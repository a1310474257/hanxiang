package com.aurira.test.util;

import com.aurora.util.DateUtils;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestUtilsData {

  @Test
  public void test1(){
    String dateString =  DateUtils.dateToString(new Date(),"yyyy-MM-dd");
    String dateString1 =  DateUtils.dateToString(new Date(),"yyyy-MM-dd HH:mm:ss");

    System.out.println(dateString);
    System.out.println(dateString1);
    System.out.println(DateUtils.getFirstDayOfMonth(2020, 4));
  }

  @Test
 public void testCompa() throws ParseException {
    String compareDate = DateUtils.compareDate("2020-04-27 22:25:56", "2020-04-25 22:26:59");
    System.out.println(compareDate);
    Date date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date first = sdf.parse("2020-04-27 22:25:56") ;
    boolean after = date.before(first);
    System.out.println(after);
  }

  @Test
  public void testDateAdd(){

//    Date date = new Date(System.currentTimeMillis());
//    String dateString1 =  DateUtils.dateToString(date,"yyyy-MM-dd HH:mm:ss");
//    System.out.println(dateString1);
//    Date date1 = DateUtils.dateAddMinute(date, -10);
//    String dateString2 =  DateUtils.dateToString(date1,"yyyy-MM-dd HH:mm:ss");
//    System.out.println(dateString2);


    Date date = new Date(System.currentTimeMillis());
    String dateString1 =  DateUtils.dateToString(date,"yyyy-MM-dd HH:mm:ss");
    System.out.println(dateString1);
    Date date1 = DateUtils.dateAddDay(date, -1);
    String dateString2 =  DateUtils.dateToString(date1,"yyyy-MM-dd HH:mm:ss");
    System.out.println(dateString2);

  }
}
