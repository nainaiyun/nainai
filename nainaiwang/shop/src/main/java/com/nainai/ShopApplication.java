package com.nainai;

import com.github.tobato.fastdfs.FdfsClientConfig;
import com.nainai.aspect.ControllerAspect;
//import net.unicon.cas.client.configuration.EnableCasClient;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.redis.cache.RedisCacheManager;

/**
 * Created by hp yan on 2018/1/4.
 *
 * @author hp yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2017. hp yan All Rights Received
 */
@SpringBootApplication
@MapperScan("com.nainai.mapper")
@ServletComponentScan("com.nainai.config")
@EnableEurekaClient
@EnableCaching
@Import(FdfsClientConfig.class)
//@EnableCasClient
public class ShopApplication {
	public static void main(String[] args) {
		SpringApplication.run(ShopApplication.class, args);
	}
}