package com.song.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.springframework.web.util.HtmlUtils;

public class htmlTest {
    @Test
    public void test1(){
        String org = "&lt;div&gt;hello world&lt;/div&gt;&lt;p&gt;&amp;nbsp;&lt;/p&gt;  ";
        System.out.println(HtmlUtils.htmlUnescape(org));
    }
}
