package com.msb.service.impl;

import com.msb.bean.Product;
import com.msb.dubbo.service.ProductDubboService;
import com.msb.mapper.ProductMapper;
import org.apache.dubbo.config.annotation.Service;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: thirteenmj
 * @date: 2022-07-23 14:42
 */
@Service
@EnableDubbo
public class ProductDubboServiceImpl implements ProductDubboService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public int insertProduct(Product product) {
        return productMapper.insertProduct(product);
    }
}
