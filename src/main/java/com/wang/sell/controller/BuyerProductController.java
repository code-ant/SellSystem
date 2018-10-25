package com.wang.sell.controller;

import com.wang.sell.VO.ProductInfoVO;
import com.wang.sell.VO.ProductVO;
import com.wang.sell.VO.ResultVO;
import com.wang.sell.dataobject.ProductCategory;
import com.wang.sell.dataobject.ProductInfo;
import com.wang.sell.service.CategoryService;
import com.wang.sell.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;
    @GetMapping("/index")
    public String index(){
        return "hello";
    }

    @GetMapping("/list")
    public ResultVO list(){
        //查询所有上架商品
        List<ProductInfo> productInfoList = productService.findUpAll();

        //查询类目
//        List<Integer> categoryTypeList = new ArrayList<>();
        //old
//        for(ProductInfo productInfo : productInfoList){
//            categoryTyoeList.add(productInfo.getCategoryType());
//        }
        //lambda
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        //数据拼装
        List<ProductVO> productVOList = new ArrayList<>();
        for(ProductCategory productCategory: productCategoryList){
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());

            List<ProductInfoVO>productInfoVOList = new ArrayList<>();
            for(ProductInfo productInfo : productInfoList){
                if(productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

        ResultVO resultVO = new ResultVO();
        resultVO.setData(productVOList);
        resultVO.setCode(0);
        resultVO.setMsg("dddd");

        return resultVO;
    }
}
