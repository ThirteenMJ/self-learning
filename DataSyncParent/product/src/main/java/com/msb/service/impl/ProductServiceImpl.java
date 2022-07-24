package com.msb.service.impl;

import com.msb.bean.Product;
import com.msb.bean.SearchPojo;
import com.msb.component.Sender;
import com.msb.dubbo.service.ProductDubboService;
import com.msb.service.ProductService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @author: thirteenmj
 * @date: 2022-07-23 15:02
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Reference
    private ProductDubboService productDubboService;

    @Autowired
    private Sender sender;

    @Override
    public int insertProduct(Product product) {
        Random random = new Random();
        product.setId(random.nextInt(5000000));

        // 保存到数据库中
        int index = productDubboService.insertProduct(product);

        if (index == 1) {
//            // 数据同步到 solr中，调用 insert 方法
//            Map<String, String> map = new HashMap<>(3);
//            map.put("id", product.getId() + "");
//            map.put("name", product.getName());
//            map.put("price", product.getPrice() + "");
//
//            String result = HttpClientUtil.doPost("http://localhost:8988/insert", map);
//
//            boolean resultBoolean = Boolean.parseBoolean(result);
//
//            System.out.println("result：" + resultBoolean);
//
//            if (!resultBoolean) {
//                // 删除数据库中的数据
//            }

            SearchPojo searchPojo = new SearchPojo();
            BeanUtils.copyProperties(product, searchPojo);
            sender.send(searchPojo);
        }

        return index;
    }
}
