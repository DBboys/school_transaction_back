package com.song.module.minio.controller;


import com.song.common.api.ApiResult;
import com.song.module.minio.service.ShizukuMinioWechatService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

@Slf4j
@RestController
@RequestMapping("/qd/wechat/Minio")
@Api(description = "Minio Wechat API",value = "QdMinioWechatController")
public class ShizukuMinioWechatController {
    @Autowired
    private ShizukuMinioWechatService service;



    //上传文件
    @PostMapping("/uploadMinioFile")
    @ApiOperation(value = "上传文件", notes = "上传文件", response = ApiResult.class)
    public ApiResult<String> uploadMinioFile(@RequestParam("file") MultipartFile file, @RequestParam("filepath") String filepath) throws Exception {
        String url = service.uploadMinioFile(file,filepath);
        return ApiResult.ok(url);
    }

    //上传文件
    @PostMapping("/uploadMinioFiles")
    @ApiOperation(value = "上传文件", notes = "上传文件", response = ApiResult.class)
    public ApiResult<String> uploadMinioFile(@RequestParam("file") MultipartFile[] file, @RequestParam("filepath") String filepath) throws Exception {
        ArrayList<String> urls = service.uploadMinioFiles(file, filepath);
        return ApiResult.ok(urls);
    }

    //删除文件
    @PostMapping("/deleteMinioFile")
    @ApiOperation(value = "删除文件", notes = "删除文件", response = ApiResult.class)
    public ApiResult<Boolean> deleteMinioFile(@RequestParam("url") String url) throws Exception{
        boolean flag = service.deleteMinioFileByUrl(url);
        return ApiResult.result(flag);
    }
}
