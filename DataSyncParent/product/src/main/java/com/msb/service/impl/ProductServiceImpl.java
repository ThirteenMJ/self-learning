package com.msb.service.impl;

import com.msb.bean.Product;
import com.msb.dubbo.service.ProductDubboService;
import com.msb.service.ProductService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

/**
 * @author: thirteenmj
 * @date: 2022-07-23 15:02
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Reference
    private ProductDubboService productDubboService;

    @Override
    public int insertProduct(Product product) {
        return productDubboService.insertProduct(product);
    }
}
