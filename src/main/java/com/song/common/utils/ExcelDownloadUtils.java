package com.song.common.utils;

import javax.servlet.http.HttpServletResponse;

/**
 * @author shizuku
 * @date 2020/2/13 20:25
 */
public class ExcelDownloadUtils {

    /**
     *
     * @param response
     */
    public static void setHttpHeader(HttpServletResponse response,String fileName){
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        //暂时不考虑中文的Excel 名称
//        fileName = URLEncoder.encode(fileName, "UTF-8");;
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
    }
}
