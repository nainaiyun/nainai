package com.nainai.config;


import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.MultipartConfigElement;

/**
 * Created by haopeng yan on 2018/1/14 23:21.
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */
@Configuration
public class FileUploadConfigurer {
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        /**
         *设置文件大小限制 ,超出设置页面会抛出异常信息，
         *这样在文件上传的地方就需要进行异常信息的处理了;
         */
        factory.setMaxFileSize("2560KB");
        /*设置总上传数据总大小*/

        factory.setMaxRequestSize("5120KB");
        /*Sets the directory location where files will be stored.*/
        /*factory.setLocation("/src/main/webapp/");*/
        return factory.createMultipartConfig();
    }
}
