package com.song.module.minio.service.impl;


import com.song.module.minio.service.ShizukuMinioWechatService;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;

@Slf4j
@Service
public class ShizukuMinioWechatServiceImpl implements ShizukuMinioWechatService {

    @Value("${minio.endpoint}")
    private String endpoint;


    @Value("${minio.accessKey}")
    private String accessKey;

    @Value("${minio.secretKey}")
    private String secretKey;

    @Value("${minio.bucketName}")
    private String bucketName;


    @Override
    public String uploadMinioFile(MultipartFile file,String filepath) throws Exception {
        //上传Minio
        MinioClient minioClient = null;
//        try {
        minioClient = new MinioClient(endpoint, accessKey, secretKey);
        minioClient.putObject(PutObjectArgs.builder().bucket("quality-development").object(filepath).stream(file.getInputStream(), file.getSize(), -1).build());
        //返回路径
        return endpoint + "/" + bucketName + "/" + filepath;
//        } catch (Exception e) {
//            throw new BusinessException("上传文件失败");
//        }
    }

    @Override
    public ArrayList<String> uploadMinioFiles(MultipartFile[] files, String filepath) throws Exception {
        ArrayList<String> filePathList = new ArrayList<>();
        for (MultipartFile file:files) {
            filePathList.add(this.uploadMinioFile(file,filepath));
        }
        return filePathList;
    }


    public String uploadMinioFileStream(InputStream inputStream,String filepath,long filesize) throws Exception {
        //上传Minio
        MinioClient minioClient = null;
//        try {
        minioClient = new MinioClient(endpoint, accessKey, secretKey);
        minioClient.putObject(PutObjectArgs.builder().bucket("quality-development").object(filepath).stream(inputStream, filesize, -1).build());
//        minioClient.putObject(PutObjectArgs.builder().bucket("quality-development").object(filepath).stream(file.getInputStream(), file.getSize(), -1).build());
        //返回路径
        return endpoint + "/" + bucketName + "/" + filepath;
//        } catch (Exception e) {
//            throw new BusinessException("上传文件失败");
//        }
    }






    @Override
    public boolean deleteMinioFileByUrl(String url) throws Exception{
        //删除Minio
        MinioClient minioClient = null;
//        try {
        minioClient = new MinioClient(endpoint, accessKey, secretKey);
        //截取对象名
        String object = url.substring(url.lastIndexOf("/") + 1);
        minioClient.removeObject(bucketName, object);
            return true;
//        } catch (Exception e) {
//            throw new BusinessException("删除文件失败");
//        }

    }

    @Override
    public boolean deleteMinioFileByObjName(String ObjName) throws Exception{
        //删除Minio
        MinioClient minioClient = null;
        minioClient = new MinioClient(endpoint, accessKey, secretKey);
        //判断对象是否存在
        if(StringUtils.isEmpty(ObjName)){
            return false;
        }
        minioClient.removeObject(bucketName, ObjName);
        return  true;

    }


    @Override
    public InputStream getMinioFile(String object) throws Exception {
        MinioClient minioClient = null;
        minioClient = new MinioClient(endpoint, accessKey, secretKey);
        //通过url获取文件
        return minioClient.getObject(bucketName, object);
    }

}
