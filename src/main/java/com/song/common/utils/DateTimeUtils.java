package com.song.common.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间和日期的工具类
 * @author shizuku
 * @date 2020/2/10 13:31
 */
public class DateTimeUtils {

    /**
     * 获取当日0:0:0 的时间
     * @return
     */
    public static Date getTodayStartTime() {
        Calendar todayStart = Calendar.getInstance();
        todayStart.set(Calendar.HOUR_OF_DAY, 0);
        set0Time(todayStart);
        return todayStart.getTime();
    }


    /**
     * 获取当日 23:59:59 秒的数据
     * @return
     */
    public static Date getTodayEndTime() {
        Calendar todayEnd = Calendar.getInstance();
        todayEnd.set(Calendar.HOUR_OF_DAY, 23);
        todayEnd.set(Calendar.MINUTE, 59);
        todayEnd.set(Calendar.SECOND, 59);
        todayEnd.set(Calendar.MILLISECOND, 999);
        return todayEnd.getTime();
    }

    /**
     * 获取中午的时间：12:00:00
     * @return
     */
    public static Date getTadayNoonTime() {
        Calendar todayEnd = Calendar.getInstance();
        todayEnd.set(Calendar.HOUR_OF_DAY, 12);
        set0Time(todayEnd);
        return todayEnd.getTime();
    }

    /**
     * 获取傍晚的时间，18:00:00
     * @return
     */
    public static Date getTodayEveningTime() {
        Calendar todayEnd = Calendar.getInstance();
        todayEnd.set(Calendar.HOUR_OF_DAY, 18);
        set0Time(todayEnd);
        return todayEnd.getTime();
    }

    /**
     * 设置 0点0分0秒
     * @param calendar
     */
    private static void set0Time(Calendar calendar){
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
    }

    /**
     *  设置当天为 23点59分59秒
     * @return
     */
    public static Date getEndTimeOfDay(Date time){
        Calendar c = Calendar.getInstance();
        c.setTime(time);
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.SECOND, 59);
        c.set(Calendar.MINUTE, 59);
        return c.getTime();
    }

    /**
     * 日期格式改为 xxxx-xx-xx
     */
    public static String simpDate(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }

    public static String compDate(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
        return sdf.format(date);
    }
}
