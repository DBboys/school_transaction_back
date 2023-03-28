package com.song.test;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.*;

public class requestDemo {
    @Test
    public void testMedScheduleTask() throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = simpleDateFormat.format(new Date());


        System.out.println(findDates("2021-10-01",format).size());


    }

    public static List<String> findDates(String startTime, String endTime)throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dBegin = sdf.parse(startTime);
        Date dEnd = sdf.parse(endTime);

        List<String> allDate = new ArrayList();
        allDate.add(sdf.format(dBegin));
        Calendar calBegin = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        calBegin.setTime(dBegin);
        Calendar calEnd = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        calEnd.setTime(dEnd);
        // 测试此日期是否在指定日期之后
        while (dEnd.after(calBegin.getTime())) {
            // 根据日历的规则，为给定的日历字段添加或减去指定的时间量
            calBegin.add(Calendar.DAY_OF_MONTH, 1);
            allDate.add(sdf.format(calBegin.getTime()));
        }
        return allDate;
    }
}
