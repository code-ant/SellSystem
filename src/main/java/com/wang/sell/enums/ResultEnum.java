package com.wang.sell.enums;

import lombok.Getter;

@Getter
public enum  ResultEnum {
    PRODUCT_NOT_EXIST(10,"不存在"),
    PRODUCT_STOCK_ERROR(11,"库存不足"),
    ;
    private Integer code;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private String msg;
}
