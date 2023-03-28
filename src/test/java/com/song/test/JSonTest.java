package com.song.test;

import org.apache.commons.text.StringEscapeUtils;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author shizuku
 * @date 2020/2/6 20:32
 */
public class JSonTest {


    @Test
    public void testEqual() {
        Long id1 = null;
        Long id2 = 123L;
        if(id1 == id2){
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }
    }

    @Test
    public void testStringFormat(){
//        String replyContent = String.format(Contents.Reply.Explain.content,"颜回");
//        System.out.println(replyContent);
    }

    @Test
    public void testIdList(){
        String longStr= "1235172654248165378";
        Long value = Long.parseLong(longStr);
        System.out.println(value);
    }


    @Test
    public void testHelloWorld(){
        String s1 = "\"hello\":1";

        String s5 = StringEscapeUtils.escapeHtml4(s1);
        System.out.println(s5);
    }


    @Test
    public void testTrim(){
        System.out.println("".trim());
    }

    @Test
    public void testTime(){
        String dateTime = "2020-02-20T04:00:00.000Z";
        dateTime = dateTime.replace("Z", " UTC");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z");
        SimpleDateFormat defaultFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date time = format.parse(dateTime);
            String result = defaultFormat.format(time);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test1(){
        String jsonString = "{" +
                "\"user\":\"kimchy1115654\"," +
                "\"postDate\":\"2020-03-28\"," +
                "\"message\":\"trying out Elasticsearch\"" +
                "}";
        String str = StringEscapeUtils.unescapeHtml4(jsonString);
        str = str.replace("\\", "").replace("\"{", "{").replace("}\"", "}");
        System.out.println(str);
    }


}
