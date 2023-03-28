package com.song.common.utils;

import org.springframework.core.io.ClassPathResource;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author : dongliwen
 * @date : 2021-03-11
 **/
public class ZipUtils {

    public static void downloadPdfToZip(String url, HttpServletResponse response,String name) throws UnsupportedEncodingException {

        setRespHead(response,name);

        response.setCharacterEncoding("UTF-8");
//        response.setHeader("content-type", "text/html; charset=utf-8");
//        response.setContentType("text/html;charset=utf-8");


        response.setHeader("Access-Control-Expose-Headers","Content-Disposition");
//        response.addHeader("Content-Disposition",new String(name.getBytes(),"utf-8"));
//        response.setHeader("Content-Disposition","attachment; filename="+java.net.URLEncoder.encode(name,"UTF-8"));

        File f = new File(url);
        File[] files = f.listFiles();
        ZipOutputStream zos = null;
        FileInputStream fis = null;
        ZipEntry ze = null;
        try {
            zos = new ZipOutputStream(response.getOutputStream());
            for (File s : files) {
                try {
                    fis = new FileInputStream(s);
                    ze = new ZipEntry(s.getName());
                    zos.putNextEntry(ze);
                    byte[] b = new byte[1024];
                    int len = -1;
                    while ((len = fis.read(b)) != -1) {
                        zos.write(b, 0, len);
                    }
                    zos.closeEntry();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                        s.delete();
                    }
                }
                s.delete();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                zos.close();
            } catch (IOException e) {
                // 如果产生错误直接删除所有文件，防止积累过多
                delDir(f);
                e.printStackTrace();
            }
        }
        if (f.exists()) {
            f.delete();
        }
    }

//    flag有以下几种：1，and：用户选择作答记录+心理报告时，对每个学生的两个pef进行打包的路径
//    2，evaluation：问卷层级打包
//    3，class：班级层级打包
//    4，grade：年级层级打包
//    5，school：学校层级打包
    public static void generateZip(String url, String name, String flag, String uuid) {
        File f = new File(url);
        File[] files = f.listFiles();
        File zipF = null;
        String zipPath = "";
        if(flag.equals("and")) {
            zipPath = new ClassPathResource("static/pdf/").getFilename() + "zip" + uuid + "/";
        }else if(flag.equals("evaluation")) {
            zipPath = new ClassPathResource("static/pdf/").getFilename() + "evaluationZip" + uuid +"/";
        }else if(flag.equals("class")) {
            zipPath = new ClassPathResource("static/pdf/").getFilename() + "classZip" + uuid + "/";
        }else if(flag.equals("grade")) {
            zipPath = new ClassPathResource("static/pdf/").getFilename() + "gradeZip" + uuid + "/";
        }else if(flag.equals("school")) {
            zipPath = new ClassPathResource("static/pdf/").getFilename() + "schoolZip" + uuid + "/";
        }else {}

        zipF = new File(zipPath);
        if(!zipF.exists()) {
            zipF.mkdir();
        }
        zipF = new File(zipPath + name + ".zip");
        OutputStream outputStream = null;
        ZipOutputStream zos = null;
        FileInputStream fis = null;
        ZipEntry ze = null;
        try {
            outputStream = new FileOutputStream(zipF);
            zos = new ZipOutputStream(outputStream);
            for (File s : files) {
                try {
                    fis = new FileInputStream(s);
                    ze = new ZipEntry(s.getName());
                    zos.putNextEntry(ze);
                    byte[] b = new byte[1024];
                    int len = -1;
                    while ((len = fis.read(b)) != -1) {
                        zos.write(b, 0, len);
                    }
                    zos.closeEntry();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                        s.delete();
                    }
                }
                s.delete();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            ZipUtils.delDir(zipF);
            delDir(f);
        } catch (IOException e) {
            e.printStackTrace();
            ZipUtils.delDir(zipF);
            delDir(f);
        } finally {
            try {
                zos.close();
            } catch (IOException e) {
                // 如果产生错误直接删除所有文件，防止积累过多
                delDir(f);
                e.printStackTrace();
            }
        }
        if (f.exists()) {
            f.delete();
        }
    }

    public static void setRespHead(HttpServletResponse response,String name){

        name = name + ".zip";
        try {
            response.setContentType("application/zip");
            response.setCharacterEncoding("utf-8");
            response.setHeader("Access-Control-Expose-Headers","Content-Disposition");
//            response.setHeader("Content-Disposition","attachment;filename=" + new String(name.getBytes("GB2312"), "ISO8859-1"));
            response.setHeader("Content-Disposition","attachment; filename="+java.net.URLEncoder.encode(name,"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public static void delDir(File file){
        if (!file.exists()) {
            return;
        }
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File file1 : files) {
                delDir(file1);
            }
            file.delete();
        } else {
            file.delete();
        }
    }
}
