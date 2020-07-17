package com.mickjoust.demo.java8pro.time;

import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * @author mickjoust
 * @since 2020/6/24
 * xxx
 **/
public class BaseTime {

    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2020, 6, 20);
        System.out.println(date);

        int year = date.getYear();
        System.out.println(year);

        Month month = date.getMonth();
        System.out.println(month);

        int day = date.getDayOfMonth();
        System.out.println(day);

        DayOfWeek dow = date.getDayOfWeek();
        System.out.println(dow);

        int len = date.lengthOfMonth();
        System.out.println(len);

        boolean leap = date.isLeapYear();
        System.out.println(leap);

        LocalDate today = LocalDate.now();
        System.out.println(today);

        LocalTime time = LocalTime.of(13, 45, 20);
        int hour = time.getHour();
        int minute = time.getMinute();
        int second = time.getSecond();

        LocalDate locadate = LocalDate.parse("2014-03-18");
        LocalTime localtime = LocalTime.parse("13:45:20");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime =LocalDateTime.parse("2020-06-24 13:00:00", formatter);
        System.out.println(localDateTime.format(formatter));

        LocalDateTime dt1 = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45, 20);
        LocalDateTime dt2 = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        System.out.println(dt2);
        LocalDateTime dt3 = date.atTime(13, 45, 20);
        LocalDateTime dt4 = date.atTime(time);
        LocalDateTime dt5 = time.atDate(date);

    }

}
