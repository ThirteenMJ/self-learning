package com.msb.component;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: thirteenmj
 * @date: 2022-07-24 14:06
 */
@Component
public class Sender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(Object object) {

        amqpTemplate.convertAndSend("demoQueue", object);
    }


}
