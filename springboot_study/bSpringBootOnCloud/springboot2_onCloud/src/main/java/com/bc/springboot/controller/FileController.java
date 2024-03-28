package com.bc.springboot.controller;

import com.bc.springboot.config.MinIOConfig;
import com.bc.springboot.utils.MinIOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@Controller
public class FileController {

    @Autowired
    private MinIOConfig minIOConfig;

    @GetMapping("/upload")
    public String upload(){
        return "fileUpload";
    }
    @PostMapping("/uploadFile")
    public String uploadFile(MultipartFile file, Model model, HttpServletRequest Request) throws Exception {
        String filename = file.getOriginalFilename();//获取文件名(此处参数file需要和前端name="file"像对应)
        //MinIOUtils.uploadFile: 文件上传
            //bucketName: 通过Config类获得
            //objectName: 文件名
            //inputStream: filename.getInputStream()
        MinIOUtils.uploadFile(minIOConfig.getBucketName(), filename, file.getInputStream());

        //文件路径拼接
        //minIOConfig.getFileHost(): 获取文件Host +“/”+minIOConfig.getBucketName(): 获取存储桶的名字+”/“+文件名
        String imgUrl=minIOConfig.getFileHost()+"/"+minIOConfig.getBucketName()+"/"+filename;

        //返回文件路径
            //前后端分离: 将文件路径抛出/封装成jsonResult返回
            //前后端不分离: 通过ModelAndView返回到页面
        model.addAttribute("imgUrl", imgUrl);
        return "/fileUpload";//将上传的图片返回展示在上传页面(此时返回的为页面逻辑视图,并不是前往该视图的映射路径)

    }
}
