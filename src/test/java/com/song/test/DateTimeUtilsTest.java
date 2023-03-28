package com.song.test;

import com.song.common.utils.DateTimeUtils;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author shizuku
 * @date 2020/2/10 13:33
 */
public class DateTimeUtilsTest {

    /**
     * 格式化工具
     */
    private static final String SDF_FORMAT = "yyyy-MM-dd HH:mm:ss";

    @Test
    public void testTodayStartEnd(){
        Date startDate = DateTimeUtils.getTodayStartTime();
        Date endDate = DateTimeUtils.getTodayEndTime();
        SimpleDateFormat sdf = new SimpleDateFormat(SDF_FORMAT);
        System.out.println("start : " + sdf.format(startDate));
        System.out.println("end : " + sdf.format(endDate));
    }
}
