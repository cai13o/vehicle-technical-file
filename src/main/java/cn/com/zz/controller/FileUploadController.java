package cn.com.zz.controller;

import com.documents4j.api.DocumentType;
import com.documents4j.api.IConverter;
import com.documents4j.job.LocalConverter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

@Api(tags = "上传文件")
@RestController
public class FileUploadController {
    private static  final Logger logger = LoggerFactory.getLogger(cn.com.zz.controller.FileUploadController.class);

    // 项目根路径下的目录  -- SpringBoot static 目录相当于是根路径下（SpringBoot 默认）
    public final static String UPLOAD_PATH_PREFIX = "static/uploadFile/";

    @ApiOperation("上传文件")
    @RequestMapping(value = "/upload", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Object upload(@RequestParam("uploadFile") MultipartFile uploadFile, HttpServletRequest request){
//        if(uploadFile.isEmpty()){
//            //返回选择文件提示
//            return "请选择上传文件";
//        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/");
        //构建文件上传所要保存的"文件夹路径"--这里是相对路径，保存到项目根路径的文件夹下
        String realPath = new String("src/main/resources/" + UPLOAD_PATH_PREFIX);
        logger.info("-----------上传文件保存的路径【"+ realPath +"】-----------");
        String format = sdf.format(new Date());
        //存放上传文件的文件夹
        File file = new File(realPath + format);
        logger.info("-----------存放上传文件的文件夹【"+ file +"】-----------");
        logger.info("-----------输出文件夹绝对路径 -- 这里的绝对路径是相当于当前项目的路径而不是“容器”路径【"+ file.getAbsolutePath() +"】-----------");
        if(!file.isDirectory()){
            //递归生成文件夹
            file.mkdirs();
        }
        //获取原始的名字  original:最初的，起始的  方法是得到原来的文件名在客户机的文件系统名称
        String oldName = uploadFile.getOriginalFilename();
        logger.info("-----------文件原始的名字【"+ oldName +"】-----------");
        String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."),oldName.length());
        logger.info("-----------文件要保存后的新名字【"+ newName +"】-----------");
        try {
            //构建真实的文件路径
            File newFile = new File(file.getAbsolutePath() + File.separator + newName);
            //转存文件到指定路径，如果文件名重复的话，将会覆盖掉之前的文件,这里是把文件上传到 “绝对路径”
            uploadFile.transferTo(newFile);
            String filePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/uploadFile/" + format + newName;
            logger.info("-----------【"+ filePath +"】-----------");
            HashMap<Object, Object> map = new HashMap<>(2);
            map.put("code","20000");
            map.put("name",oldName);
            map.put("suffix",oldName.substring(oldName.lastIndexOf(".")+1));
            map.put("size", uploadFile.getSize());

            String pdfName = UUID.randomUUID().toString() + ".pdf";
            File outputFile = new File(file.getAbsolutePath() + File.separator + pdfName);
            if(oldName.substring(oldName.lastIndexOf(".")+1).equals("docx")){
                try  {
                    outputFile.createNewFile();
                    InputStream docxInputStream = new FileInputStream(newFile);
                    OutputStream outputStream = new FileOutputStream(outputFile);
                    IConverter converter = LocalConverter.builder().build();
                    converter.convert(docxInputStream).as(DocumentType.DOCX).to(outputStream).as(DocumentType.PDF).execute();
                    outputStream.close();
                    System.out.println("success");
                    map.put("filePath",request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/uploadFile/" + format + pdfName);
                    return map;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if(oldName.substring(oldName.lastIndexOf(".")+1).equals("doc")){
                try  {
                    outputFile.createNewFile();
                    InputStream docxInputStream = new FileInputStream(newFile);
                    OutputStream outputStream = new FileOutputStream(outputFile);
                    IConverter converter = LocalConverter.builder().build();
                    converter.convert(docxInputStream).as(DocumentType.DOC).to(outputStream).as(DocumentType.PDF).execute();
                    outputStream.close();
                    System.out.println("success");
                    map.put("filePath",request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/uploadFile/" + format + pdfName);
                    return map;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            map.put("filePath",filePath);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "上传失败!";
    }

}
