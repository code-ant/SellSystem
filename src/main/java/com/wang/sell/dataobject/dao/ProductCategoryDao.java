package com.wang.sell.dataobject.dao;

import com.wang.sell.dataobject.ProductCategory;
import com.wang.sell.dataobject.mapper.ProductCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class ProductCategoryDao {

    @Autowired
    ProductCategoryMapper mapper;

    public int insertBuMap(Map<String, Object> map) {
        return mapper.insertByMap(map);
    }
}
