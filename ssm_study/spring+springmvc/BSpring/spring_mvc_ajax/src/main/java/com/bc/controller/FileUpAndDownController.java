package com.bc.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

//下载不同文件时,只有路径不同
@Controller
public class FileUpAndDownController {
    @RequestMapping("/test/down")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session)throws IOException{
        //通过session获取SerletContext对象
        ServletContext servletContext=session.getServletContext();
        //servletContext中的方法getRealPath获取当前某个文件的真实路径   获取当前某个资源在服务器上的路径
        //设置""空字符串时,获取当前工程在服务器中的路径
        //设置不为空字符串时,将""中的内容拼接到 当前工程在服务器中的路径 后(不管文件在""内的路径是否存在)
        String realPath = servletContext.getRealPath("img");
        //获取/img/tx.jpg的路径  从web服务器下载
        //避免 / \ 书写错误,使用File.separator文件分割符手动拼接
        realPath=realPath+ File.separator+"tx.jpg";
        System.out.println("realPath::"+realPath);
        //要把下载的文件响应到浏览器,只需要把文件所有的字节响应到浏览器 就可以实现下载的功能
        //创建输入流 当前输入流读取的是tx.jpg
        InputStream inputStream=new FileInputStream(realPath);
        //创建byte类型的数组(响应体)
        //inputStream.available():获取当前字节输入流所对应的文件 的所有字节数    文件有多少字节,数组就设置多少长度
        byte[] bytes=new byte[inputStream.available()];
        //将输入流对应文件的所有字节都读到当前数组中
        inputStream.read(bytes);
        //创建HttpHeaders对象设置响应头信息
        //响应头、请求头本质都为键值对
        MultiValueMap<String,String> headers=new HttpHeaders();
        //设置下载方式，下载文件的名字 放入响应头
        //Content-Disposition:以附件的方式进行下载(有弹窗)
        //filename:下载下来的文件默认的名字
        headers.add("Content-Disposition", "attachment;filename=tx.jpg");
        //设置响应状态码
        //设置为200,使执行成功后响应回浏览器的状态是成功(200)
        HttpStatus statusCode=HttpStatus.OK;
        //创建ResponseEntity对象
        //bytes:响应体
        //headers:响应头
        //statusCode:响应状态码
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers, statusCode);
        inputStream.close();
        return responseEntity;
    }





    //文件上传      把文件上传到web服务器中
    @RequestMapping("test/up")
    public String testUp(HttpSession session, MultipartFile photo) throws IOException {
        //获取上传文件的文件名
        String filename = photo.getOriginalFilename();

        //重名处理 uuid
        //获取上传的文件后缀名
        //.substring字符截取,从xx开始截,截到结尾,包前不包后
        //获取最后一次出现 . 的索引
        String suffixName = filename.substring(filename.lastIndexOf("."));
        //获取uuid uuid:java.util包下 再转换为字符串
        String uuid = UUID.randomUUID().toString();
        //拼接新的文件名 filename=uuid+后缀名
        filename=uuid+suffixName;
        System.out.println(filename);

        //获取工程在服务器中的路径
        ServletContext servletContext=session.getServletContext();
        //获取当前工程下photo目录的真实路径
        String photoPath = servletContext.getRealPath("photo");
        System.out.println("photoPath:"+photoPath);
        //创建photoPath对应的File对象,该文件对象对应photo目录的路径
        File file=new File(photoPath);

        //判断file所对应目录是否存在   把file上传到photo目录下,photo可能不存在
        //或自己手动在webapp下创建
        if (!file.exists()){
            file.mkdir();
        }
        //设置最终上传的路径 war包下的photo目录+分隔符+上传的文件名
        String finalPath=photoPath+File.separator+filename;

        //文件上传
        photo.transferTo(new File(finalPath));
//        FileUtils.copyInputStreamToFile(photo.getInputStream(), new File());
        return "hello";
    }
}
