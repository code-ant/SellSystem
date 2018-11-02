package com.wang.sell.dataobject.mapper;

import com.wang.sell.dataobject.ProductCategory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProductCategoryMapperTest {

    @Test
    public void selectByType(){
        ProductCategory productCategory = mapper.selectByType(111);
        Assert.assertNotNull(productCategory);
    }

    @Autowired
    private ProductCategoryMapper mapper;

    @Test
    public void updateByObject(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("object1111111111111111111");
        productCategory.setCategoryType(110);
        int resu = mapper.updateByObject(productCategory);
        Assert.assertEquals(1,resu);
    }
    @Test
    public void insertByMap() {
        Map<String,Object> map = new HashMap<>();
        map.put("category_name","mybaties");
        map.put("category_type",101);
        int result = mapper.insertByMap(map);
        Assert.assertEquals(1,result);
    }

    @Test
    public void updateByCategoryType(){
        int rrr = mapper.updateByCategoryType("string1111",111);
        assertEquals(1,rrr);
    }
    @Test
    public void insertByObject(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("object");
        productCategory.setCategoryType(110);
        int result = mapper.insertByObject(productCategory);
        Assert.assertEquals(1,result);
    }
    @Test
    public void findByCategoryType(){
        ProductCategory re = mapper.findByCategoryType(111);
        Assert.assertNotNull(re);
    }

    @Test
    public void deleteByCategoryType(){
        int res = mapper.deleteByCategoryType(110);
        assertEquals(1,res);
    }

    @Test
    public void findByCategoryName(){
        List<ProductCategory> re = mapper.findByCategoryName("object");
        Assert.assertNotEquals(0,re);
    }
}