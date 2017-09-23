package com.kevin.common.date;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Jkevin on 2017/9/23.
 */
public class TestDate {
    /*    public static void main(String[] args) {
            Calendar calendar = Calendar.getInstance();
            System.err.println("NOW:" + calendar);
            String indate = "2017-09-12";
            try {
                calendar.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(indate));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            calendar.add(Calendar.DAY_OF_YEAR, 29);
            System.out.println(calendar.getTime());
        }*/
    public static void main(String[] args) {
        DateTime date = new DateTime();
        System.err.println("NOW: " + date);
        System.err.println("NOW day: " + date.getDayOfMonth());
        System.err.println("NOW: " + DateTime.now().dayOfMonth().get());

        DateTimeFormatter format = DateTimeFormat.forPattern("yyyy-MM-dd");

        String in = "2017-09-12";
        DateTime date2 = DateTime.parse(in, format);
        System.out.println("今天【取车时间】: " + date2.toString(format));
        System.out.println("显示天租结束时间: " + date2.plusDays(29).toString(format));
    }
}
