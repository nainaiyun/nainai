package com.nainai.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * Created by haopeng yan on 2018/2/4 21:26.
 *
 * @author haopeng yan
 * @version 1.0
 * @since 1.0
 * Copyright (C) 2018. haopeng yan All Rights Received
 */
@Configuration
@EnableRedisHttpSession
public class RedisSessionConfigurer {
}
