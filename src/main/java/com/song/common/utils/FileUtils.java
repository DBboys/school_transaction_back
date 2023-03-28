package com.song.common.utils;

import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

/**
 * @author shizuku
 * @date 2019/8/24 15:21
 */
public class FileUtils {

    public static String getFilePostFix(String fileName){
        String postFix = "";
        if(StringUtils.isEmpty(fileName)){
            return postFix;
        }
        postFix = fileName.substring(fileName.lastIndexOf(".") + 1);
        return postFix;
    }

    public static void setHeadToPdf(HttpServletResponse response,String name){

        try {
            response.setContentType("application/pdf");
            response.setCharacterEncoding("utf-8");
            response.setHeader("Content-Disposition","attachment;filename=" + new String(name.getBytes("GB2312"), "ISO8859-1"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public static void setHeadToPng(HttpServletResponse response,String name){

        try {
            response.setContentType("image/png");
            response.setCharacterEncoding("utf-8");
            response.setHeader("Content-Disposition","attachment;filename=" + new String(name.getBytes("GB2312"), "ISO8859-1"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
