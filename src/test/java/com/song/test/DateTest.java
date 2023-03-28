package com.song.test;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author: Laity
 * @Project: JavaLaity
 * @Package: com.intelligent.car.test.DateTest
 * @Date: 2022年07月23日 19:46
 * @Description:
 */
@SpringBootTest
public class DateTest {
    @Test
    public void test(){
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String format = dateFormat.format(date);
        String[] splits = format.split("-");
        for (String split : splits) {
            System.out.println(split);
        }
        System.out.println(splits[0]);

//        System.out.println(date);
//        int year = date.getYear();
//        long time = date.getTime();
//        System.out.println(time);
//        int month = date.getMonth();
//        System.out.println(month + 1);
//        System.out.println(year);

    }
    @Test
    public void test2(){
//
//        String[] a = {"1", "list"};
//        List b = new ArrayList();
//        b.add(a[0]);
//        List c = new ArrayList();
//        // c.add()
//        Long[] d = {(Long) b.get(0)};
//        System.out.println(d);
    }
}
