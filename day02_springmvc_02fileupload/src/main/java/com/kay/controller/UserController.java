package com.kay.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.util.List;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * 传统的文件上传
     * @return
     */
    @RequestMapping("/fileupload1")
    public String fileupload1(HttpServletRequest request) throws Exception{//所有的请求都被包含在request中
        System.out.println("文件上传....");

        //使用fileupload组件完成文件上传
        //上传的位置
        String path = request.getSession().getServletContext().getRealPath("/uploads");

        //判断该路径是否存在
        File file = new File(path);
        if(!file.exists()){
            //创建该文件夹
            file.mkdirs();
        }
        //解析request对象，获取上传的文件项

        DiskFileItemFactory factory = new DiskFileItemFactory();//磁盘文件项工厂，用来创建文件
        ServletFileUpload upload = new ServletFileUpload(factory);
        //解析request
        List<FileItem> items = upload.parseRequest(request);//会抛出异常

        //遍历
        for(FileItem item:items){
            //进行一个判断，判断当前的item对象是否的是一个上传文件的项
            if(item.isFormField()){
                //说明它是一个普通的表单项

            }else{
                //说明它是一个上传文件项
                //获取上传文件的名称
                String filename = item.getName();
                //将文件的名字设置成唯一的值，uuid
                String uuid = UUID.randomUUID().toString().replace("-"," ");
                filename = uuid + "_"+ filename;
                //完成文件的上传
                item.write(new File(path,filename));
                //删除临时文件
                item.delete();
            }
        }
        return "success";
    }



    /**
     * SpringMVC的文件上传
     * @return
     */
    @RequestMapping("/fileupload2")
    public String fileupload2(HttpServletRequest request, MultipartFile upload) throws Exception{//upload必须和表单的中一致
        System.out.println("文件上传....");

        //使用fileupload组件完成文件上传
        //上传的位置
        String path = request.getSession().getServletContext().getRealPath("/uploads");

        //判断该路径是否存在
        File file = new File(path);
        if(!file.exists()){
            //创建该文件夹
            file.mkdirs();
        }

        //说明它是一个上传文件项
        //获取上传文件的名称
        String filename = upload.getOriginalFilename();
        //将文件的名字设置成唯一的值，uuid
        String uuid = UUID.randomUUID().toString().replace("-"," ");
        filename = uuid + "_"+ filename;
        //完成文件的上传
        upload.transferTo(new File(path,filename));
        return "success";
    }



    /**
     * 跨服务器上传文件
     * @return
     */
    @RequestMapping("/fileupload3")
    public String fileupload3(MultipartFile upload) throws Exception{//upload必须和表单的中一致
        System.out.println("跨服务器文件上传....");

        //定义一个上传文件服务器的路径
        String path = "http://localhost:9090/uploads/";


        //说明它是一个上传文件项
        //获取上传文件的名称
        String filename = upload.getOriginalFilename();
        //将文件的名字设置成唯一的值，uuid
        String uuid = UUID.randomUUID().toString().replace("-","");
        filename = uuid + "_"+ filename;

        //创建客户端的对象
        Client client = Client.create();
        //和图片服务器进行连接
        WebResource webResource = client.resource(path+filename);
        //上传文件
        webResource.put(upload.getBytes());//通过字节的方式将文件传过去
        //若想要上传成功则必须要在图片的服务器上conf/wen.xml文件中关闭只读的设置以下设置
        // <init-param>
        //      <param-name>readonly</param-name>
        //      <param-value>false</param-value>
        // </init-param>
        return "success";
    }

}
