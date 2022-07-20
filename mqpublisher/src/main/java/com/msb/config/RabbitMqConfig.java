package com.msb.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: thirteenmj
 * @date: 2022-07-19 21:15
 */
@Configuration
public class RabbitMqConfig {

    @Bean
    public Queue queue() {
        return new Queue("myQueue");
    }

    @Bean
    public Queue createQueue1() {
        return new Queue("myFanout1");
    }

    @Bean
    public Queue createQueue2() {
        return new Queue("myFanout2");
    }

    @Bean
    public FanoutExchange getFanoutExchange() {
        return new FanoutExchange("amq.fanout");
    }

    @Bean
    public Binding binding(Queue createQueue1, FanoutExchange getFanoutExchange) {
        return BindingBuilder
                .bind(createQueue1)
                .to(getFanoutExchange);
    }

    @Bean
    public Binding binding2(Queue createQueue2, FanoutExchange getFanoutExchange) {
        return BindingBuilder
                .bind(createQueue2)
                .to(getFanoutExchange);
    }


}
