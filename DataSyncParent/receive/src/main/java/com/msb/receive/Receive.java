package com.msb.receive;

import com.msb.bean.SearchPojo;
import com.msb.util.HttpClientUtil;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: thirteenmj
 * @date: 2022-07-24 16:48
 */
@Component
public class Receive {

    @RabbitListener(queues = "demoQueue")
    public void solr(Object object) {
        Message message = (Message) object;
        try {
            // 从消息中获取要保存的对象
            ByteArrayInputStream bio = new ByteArrayInputStream(message.getBody());
            ObjectInputStream ois = new ObjectInputStream(bio);
            Object obj = ois.readObject();
            SearchPojo searchPojo = (SearchPojo) obj;
            // 调用 HttpClient 方法执行 http 连接，进行 insert 操作
            Map<String, String> map = new HashMap<>(3);
            map.put("id", searchPojo.getId() + "");
            map.put("name", searchPojo.getName());
            map.put("price", searchPojo.getPrice() + "");
            HttpClientUtil.doPost("http://localhost:8988/insert", map);
            bio.close();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
