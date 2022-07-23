package com.msb.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: thirteenmj
 * @date: 2022-07-19 21:15
 */
@Configuration
public class RabbitMqConfig {

    /**
     * 垂直交换器
     *
     * @return
     */
    @Bean
    public Queue queue() {
        return new Queue("myQueue");
    }

    /**
     * 环形交换器
     *
     * @return
     */
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

    @Bean
    public Queue topicQueue1() {
        return new Queue("topic1");
    }

    @Bean
    public Queue topicQueue2() {
        return new Queue("topic2");
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange("amq.topic");
    }

    /**
     * * 只能代替 两个点之间的内容，
     * # 表示 0个 或者多个字符
     *
     * @param topicQueue1
     * @param topicExchange
     * @return
     */
    @Bean
    public Binding topicBinding(Queue topicQueue1, TopicExchange topicExchange) {
        return BindingBuilder.bind(topicQueue1).to(topicExchange).with("com.msb.*");
    }

    @Bean
    public Binding topicBinding2(Queue topicQueue2, TopicExchange topicExchange) {
        return BindingBuilder.bind(topicQueue2).to(topicExchange).with("com.msb.#");
    }


}
