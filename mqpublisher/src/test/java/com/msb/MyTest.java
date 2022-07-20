package com.msb;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author: thirteenmj
 * @date: 2022-07-19 21:19
 */
@SpringBootTest(classes = PublisherApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class MyTest {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Test
    public void testMethod() {
        amqpTemplate.convertAndSend("myQueue", "这是我的内容");
        System.out.println("发送成功!");
    }

    @Test
    public void testMethod2() {
        amqpTemplate.convertAndSend("amq.fanout", "core", "fanout msg");
        System.out.println("发送成功!");
    }
}
