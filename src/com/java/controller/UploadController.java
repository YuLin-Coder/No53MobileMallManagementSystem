package com.java.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.alibaba.druid.support.logging.Resources;
import com.java.utils.CommonUtils;
import com.java.utils.StringUtil;






@Controller
public class UploadController {
	String project_path=StringUtil.GetProject();
	
	//////////////////////////////////////////////
	//////////////上传接口////////////////////////
	/////////////////////////////////////////////
    @ResponseBody
    @RequestMapping("upload")
    public String uploadFile(HttpServletRequest request,@Param("file") MultipartFile file) throws IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSS");
        //String res = sdf.format(new Date());//以yyyyMMddHHmmssSS格式命名
        String res=StringUtil.SetOnlyKey();
        String root = request.getSession().getServletContext().getRealPath("/");//物理根路径
        //服务器上使用
       // String rootPath =request.getServletContext().getRealPath("/resource/uploads/");//target的目录
        //本地使用
        String rootPath =root+"file/";
        //原始名称
        String originalFilename = file.getOriginalFilename();
        //新的文件名称
        String newFileName = res+originalFilename.substring(originalFilename.lastIndexOf("."));
        //创建年月文件夹
        Calendar date = Calendar.getInstance();
        File dateDirs = new File(String.valueOf(date.get(Calendar.MONTH)+1));
        //新文件
        File newFile = new File(rootPath+File.separator+dateDirs+File.separator+newFileName);
        //判断目标文件所在的目录是否存在
        if(!newFile.getParentFile().exists()) {
            //如果目标文件所在的目录不存在，则创建父目录
            newFile.getParentFile().mkdirs();
        }
        System.out.println(newFile);
        //将内存中的数据写入磁盘
        file.transferTo(newFile);
        
        //完整的url
        String fileUrl =  "file/"+(date.get(Calendar.MONTH)+1)+ "/"+ newFileName;
        Map<String,Object> map = new HashMap<String,Object>();
        Map<String,Object> map2 = new HashMap<String,Object>();
        map.put("code",0);//0表示成功，1失败
        map.put("msg","上传成功");//提示消息
        map.put("data",map2);
        map2.put("src",fileUrl);//图片url
        map2.put("title",newFileName);//图片名称，这个会显示在输入框里
        String result = new JSONObject(map).toString();
        copyFileUsingFileStreams(newFile,dateDirs,newFileName);
        //System.out.println(project_dir);
        return result;
    }
    
    private void copyFileUsingFileStreams(File source,File datedirs,String newfilename)
            throws IOException { 
    	project_path+=project_path.toLowerCase().indexOf("webroot")<0?"/WebRoot/file/":"";//同时复制附件到项目下面
    	//新文件
        File newFile = new File(project_path+File.separator+datedirs+File.separator+newfilename);
        //判断目标文件所在的目录是否存在
        if(!newFile.getParentFile().exists()) {
            //如果目标文件所在的目录不存在，则创建父目录
            newFile.getParentFile().mkdirs();
        }
        InputStream input = null;    
        OutputStream output = null;    
        try {
               input = new FileInputStream(source);
               output = new FileOutputStream(newFile);        
               byte[] buf = new byte[1024];        
               int bytesRead;        
               while ((bytesRead = input.read(buf)) > 0) {
                   output.write(buf, 0, bytesRead);
               }
        } finally {
            input.close();
            output.close();
        }
    }
    
    
}


