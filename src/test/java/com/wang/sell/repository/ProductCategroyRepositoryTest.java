package com.wang.sell.repository;

import com.wang.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategroyRepositoryTest {

    @Autowired
    private ProductCategroyRepository repository;

    @Test
    public void findOneTest(){
        ProductCategory productCategroy = repository.findById(1).orElse(null);
        System.out.println(productCategroy.toString());
    }

    @Test
    @Transactional
    public void saveTest(){
        ProductCategory productCategory = new ProductCategory("牛奶",4);
        ProductCategory result = repository.save(productCategory);
        Assert.assertNotNull(result);
    }

    @Test
    public void updateTest(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(2);
        productCategory.setCategoryName("啤酒饮料");
        productCategory.setCategoryType(93);
        repository.save(productCategory);
    }

    @Test
    public void updateTest1(){
        ProductCategory productCategory = repository.findById(2).orElse(null);
        productCategory.setCategoryType(2);
        repository.save(productCategory);
    }

    @Test
    public void findByCategoryTypeInTest(){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);

        List<ProductCategory> result = repository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,result.size());
    }
}