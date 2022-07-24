package com.msb.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: thirteenmj
 * @date: 2022-07-24 14:04
 */
@Configuration
public class SenderConfig {

    @Bean
    protected Queue queue() {
        return new Queue("demoQueue");
    }
}
