package com.msb.receive;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author: thirteenmj
 * @date: 2022-07-19 23:08
 */
@Component
public class DemoReceive {

    @RabbitListener(queues = "myQueue")
    public void demo(String message) {
        System.out.println("获取到的消息111：" + message);
    }

    @RabbitListener(queues = "myQueue")
    public void demo2(String message) {
        System.out.println("获取到的消息222：" + message);
    }

    @RabbitListener(queues = "myFanout1")
    public void demo3(String message) {
        System.out.println("fanout1:" + message);
    }

    @RabbitListener(queues = "myFanout2")
    public void demo4(String message) {
        System.out.println("fanout2:" + message);
    }

    @RabbitListener(queues = "topic1")
    public void demo5(String message) {
        System.out.println("topic1:" + message);
    }

    @RabbitListener(queues = "topic2")
    public void demo6(String message) {
        System.out.println("topic2:" + message);
    }
}
