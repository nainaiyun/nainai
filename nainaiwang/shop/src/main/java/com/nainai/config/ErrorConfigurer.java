package com.nainai.config;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/**
 * Created by haopeng yan on 2018/1/4 16:35.
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */
@Configuration
public class ErrorConfigurer  {
    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer(){
        return  new EmbeddedServletContainerCustomizer() {
            @Override
            public void customize(ConfigurableEmbeddedServletContainer container) {
                container.addErrorPages(new ErrorPage(HttpStatus.BAD_REQUEST,"/400"));
                container.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR,"/500"));
                container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND,"/404"));
            }
        };
    }
}
