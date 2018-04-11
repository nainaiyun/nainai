package com.nainai.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by haopeng yan on 2018/1/4 16:35.
 * Swagger2自动生成RESTful API文档配置类
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */
@EnableSwagger2
@Configuration
public class Swagger2Configurer {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                /*为当前包路径*/
                .apis(RequestHandlerSelectors.basePackage("com.nainai.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * api文档的详细信息函数
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                /*页面标题*/
                .title("店铺模块接口文档")
                /*创建人*/
                .contact(new Contact("颜浩鹏", "http://www.dear520.top", "yanhaupeng@163.com"))
                /*版本号*/
                .version("1.0")
                /*描述*/
                .description("API 描述")
                .build();
    }
}
