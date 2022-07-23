package com.msb.mapper;

import com.msb.bean.Product;
import org.springframework.stereotype.Repository;

/**
 * @author: thirteenmj
 * @date: 2022-07-23 12:53
 */
@Repository
public interface ProductMapper {

    int insertProduct(Product product);
}
