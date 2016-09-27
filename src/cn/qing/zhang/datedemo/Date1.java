package cn.qing.zhang.datedemo;

import org.junit.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.Period;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * @Description:java8 相关日期类
 * @author: qing.zhang
 * @date: 2016/9/27 14:42
 */
public class Date1 {

    public static void main(String[] args) {
        //1,获取当天日期
        //日期类只有日期没有时间会自动格式话
        LocalDate today = LocalDate.now();
        System.out.println("今天日期为:"+today);//今天日期为:2016-09-27
        Date date = new Date();
        System.out.println(date);//Tue Sep 27 14:45:50 CST 2016
        //2,Java 8中获取当前的年月日
        int year = today.getYear();
        int monthValue = today.getMonthValue();
        int dayOfMonth = today.getDayOfMonth();
        System.out.printf("今天年份为 %d 月份 %d 每月的第%d天 \n ",year,monthValue,dayOfMonth);
        //3,在Java 8中如何获取某个特定的日期
        LocalDate birthDay = LocalDate.of(1993,3,8);
        System.out.println("生日为:"+birthDay);// 生日为:1993-03-08
        //4,在Java 8中如何检查两个日期是否相等
        if(today.equals(birthDay)){
            System.out.println("今天和生日是同一天");
        }else{
            System.out.println("今天和生日不是同一天");//今天和生日不是同一天
        }
        //5,比较月份 每月生日发信息
        MonthDay birthMonthDay = MonthDay.of(birthDay.getMonth(),birthDay.getDayOfMonth());
        MonthDay todayMonthDay = MonthDay.from(today);
        if(birthMonthDay.equals(todayMonthDay)){
            System.out.println("今天是生日非常开心");
        }else{
            System.out.println("今天不是我生日");//今天不是我生日
        }
    }

    @Test
    public void testTime(){
        //1,获取当前时间
        LocalTime time = LocalTime.now();
        System.out.println("当前时间"+time);//当前时间15:22:04.352  格式时分秒 纳秒
        //2如何增加时间里面的小时数 time不可变 每次产生一个新的引用
        LocalTime newTime = time.plusHours(2);
        System.out.println("增加2小时后时间为"+newTime);//增加2小时后时间为17:24:25.484
        //本地和美国
        LocalDateTime localDateTime = LocalDateTime.now();
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.of("America/New_York"));
        System.out.println("本地时间"+localDateTime+"美国纽约时间"+zonedDateTime);
    //    本地时间2016-09-27T15:59:00.601美国纽约时间2016-09-27T15:59:00.601-04:00[America/New_York]
    }

    @Test
    public void testYear(){
        //chronounit 表示添加的时间单位 小时，分钟，月，年
        LocalDate today = LocalDate.now();
        LocalDate nextWeek = today.plusWeeks(1);
        LocalDate nexMonth = today.plus(1, ChronoUnit.MONTHS);
        System.out.println("今天"+today+"一周后"+nextWeek+"下个月"+nexMonth);//今天2016-09-27一周后2016-10-04下个月2016-10-27
        LocalDate frontYear = today.minus(1, ChronoUnit.YEARS);
        LocalDate nextYear = today.plus(1, ChronoUnit.YEARS);
        System.out.println("去年"+frontYear+"明年"+nextYear);//去年2015-09-27明年2017-09-27
        //在Java中如何判断某个日期是在另一个日期的前面还是后面
        if(nextWeek.isAfter(today)){
            System.out.println("下周在今天之后");
        }
        if(nextWeek.isBefore(nexMonth)){
            System.out.println("下周在下月之前");
        }
        //判断是否是闰年
        if(today.isLeapYear()){
            System.out.println("今年是闰年");
        }else {
            System.out.println("今年不是闰年");
        }
        //下周和下月间隔几天
        Period between = Period.between(nextWeek, nexMonth);
        System.out.println("下个月和下周间隔几天"+between.getDays());//下个月和下周间隔几天-23
    }

    @Test
    public void testClock(){
        //在Java 8中使用时钟
        Clock clock = Clock.systemUTC();
        Clock clock1 = Clock.systemDefaultZone();
        System.out.println("当前时间"+clock.millis()+"\n"+"当前时间地区"+clock1+"时间戳"+System.currentTimeMillis());
        //当前时间1474962408836
        //当前时间地区SystemClock[Asia/Shanghai]时间戳1474962408836
        Instant instant = Instant.now();//时间戳和之前date类似
        System.out.println(instant);
    }

    @Test
    public void testYearMonth(){
        //例如信用卡还款日
        YearMonth yearMonth = YearMonth.now();
        System.out.printf("当前年 %s 当前月长度 %d ",yearMonth,yearMonth.lengthOfMonth());
        YearMonth creditCardYear = YearMonth.of(2020, Month.JULY);
        System.out.println("还款日"+creditCardYear);

    }

}
