package com.aurora.web.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.IOUtils;



import java.io.File;
import java.io.IOException;

@Api(value = "文件上传接口",description = "提供增删查改")
@RestController
@RequestMapping("/upload")
public class Upload {

    @Value("${aurora.hanxiang.image_path}")
    private String imgPath;


    @ApiOperation("上传图片")
    @PostMapping("/image")
    public void UploadImage(@RequestParam("fileName") MultipartFile file) throws IOException {
        String name = file.getOriginalFilename();
        file.getSize();
        File file1 = new File(imgPath+name);

        //判断文件父目录是否存在
        if(!file1.getParentFile().exists()){
            file1.getParentFile().mkdir();
        }
          file.transferTo(file1);
    }
}
