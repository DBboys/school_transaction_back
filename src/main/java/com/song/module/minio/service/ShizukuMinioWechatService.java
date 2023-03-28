package com.song.module.minio.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;

public interface ShizukuMinioWechatService {
    //上传文件
    String uploadMinioFile(MultipartFile file, String filepath) throws Exception;

    ArrayList<String> uploadMinioFiles(MultipartFile[] file, String filepath) throws Exception;

    //删除文件
    boolean deleteMinioFileByUrl(String url) throws Exception;


    //删除文件
    boolean deleteMinioFileByObjName(String ObjName) throws Exception;

    //获得文件流
    InputStream getMinioFile(String Object) throws Exception;

    //上传文件
    String uploadMinioFileStream(InputStream inputStream, String filepath,long filesize) throws Exception;
}
