package com.nainai.controller;

/**
 * Created by haopeng yan on 2018/1/14 23:20.
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.nainai.common.Result;
import com.nainai.common.ResultGenerator;
import com.nainai.util.UUIDGenerator;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.List;

@RestController
@RequestMapping(value = "/file")
public class FileUploadController {
    @Autowired
    public FastFileStorageClient fastFileStorageClient;

    /**
     * 上传单个文件
     *
     * @param file
     * @return
     */
    @ApiOperation(value = "上传单个文件", notes = "上传单个文件至服务器")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "MultipartFile", name = "file", value = "MultipartFile文件对象", required = true)
    })
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public Result upload(@RequestParam("file") MultipartFile file) {
        //判断文件是否为空
        if (file.isEmpty()) {
            return ResultGenerator.genFailResult("文件为空");
        }
        // 获取文件名
        String fileName = file.getOriginalFilename();
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        //获取文件类型
        String filetype = file.getContentType();
        //获取文件大小
        long size = file.getSize();
        // 文件上传后的路径
        String filePath = "/Users/yanhaopeng/Pictures";
        // 解决中文问题，liunx下中文路径，图片显示问题
        fileName = UUIDGenerator.getUUID() + suffixName;
        File dest = new File(filePath + fileName);
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            //上传
            file.transferTo(dest);
            //上传后输出上传成功的时间
            return ResultGenerator.genSuccessResult("/static/pictures/" + fileName);
        } catch (IllegalStateException e) {
            return ResultGenerator.genFailResult("文件过大,内存溢出异常");
        } catch (IOException e) {
            return ResultGenerator.genFailResult("文件路径错误,IO异常");
        }


        //        if (!file.isEmpty()) {
//            try {
//                // 这里只是简单例子，文件直接输出到项目路径下。
//                // 实际项目中，文件需要输出到指定位置，需要在增加代码处理。
//                // 还有关于文件格式限制、文件大小限制，详见：中配置。
//                BufferedOutputStream out = new BufferedOutputStream(
//                        new FileOutputStream(new File(file.getOriginalFilename())));
//                out.write(file.getBytes());
//                out.flush();
//                out.close();
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//                return "上传失败," + e.getMessage();
//            } catch (IOException e) {
//                e.printStackTrace();
//                return "上传失败," + e.getMessage();
//            }
//            return "上传成功";
//        } else {
//            return "上传失败，因为文件是空的.";
//        }
    }

    /**
     * 上传单个文件
     *
     * @param file
     * @return
     */
    @ApiOperation(value = "上传单个文件", notes = "上传单个文件至服务器")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "MultipartFile", name = "file", value = "MultipartFile文件对象", required = true)
    })
    @RequestMapping(value = "/uploadOne", method = RequestMethod.POST)
    public Result uploadOne(@RequestParam("file") MultipartFile file) {
        //判断文件是否为空
        if (file.isEmpty()) {
            return ResultGenerator.genFailResult("文件为空");
        }
        // 获取文件名
        String fileName = file.getOriginalFilename();
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        //获取文件类型
        String filetype = file.getContentType();
        //获取文件大小
        long size = file.getSize();
        String filePath = "/Users/yanhaopeng/Pictures";
        File dest = new File(filePath + fileName);
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
            FileInputStream inputStream = new FileInputStream(dest);

            String strs = fileName.substring(fileName.lastIndexOf(".") + 1);
            ;
            if (!StringUtils.hasText(strs)) {
                return ResultGenerator.genFailResult("fail");
            }
            StorePath storePath = fastFileStorageClient.uploadImageAndCrtThumbImage(inputStream, file.getSize(), strs, null);
            System.out.println("path------" + storePath.getFullPath());
            String path = "http://210.51.161.217:8088/" + storePath.getFullPath();
            //上传后输出上传成功的时间
            return ResultGenerator.genSuccessResult(path);
        } catch (IllegalStateException e) {
            return ResultGenerator.genFailResult("文件过大,内存溢出异常");
        } catch (IOException e) {
            return ResultGenerator.genFailResult("文件路径错误,IO异常");
        }
    }


    /**
     * 多文件上传 主要是使用了MultipartHttpServletRequest和MultipartFile
     *
     * @param request
     * @return
     * @author
     * @create 2018/1/14
     */
    @RequestMapping(value = "/upload/batch", method = RequestMethod.POST)
    public @ResponseBody
    String batchUpload(HttpServletRequest request) {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        MultipartFile file = null;
        BufferedOutputStream stream = null;
        for (int i = 0; i < files.size(); ++i) {
            file = files.get(i);
            if (!file.isEmpty()) {
                try {
                    byte[] bytes = file.getBytes();
                    stream = new BufferedOutputStream(new FileOutputStream(new File(file.getOriginalFilename())));
                    stream.write(bytes);
                    stream.close();
                } catch (Exception e) {
                    stream = null;
                    return "You failed to upload " + i + " => " + e.getMessage();
                }
            } else {
                return "You failed to upload " + i + " because the file was empty.";
            }
        }
        return "upload successful";
    }
}
