package com.wang.sell.enums;

import lombok.Getter;

@Getter
public enum  ResultEnum {
    PRODUCT_NOT_EXIST(10,"不存在"),
    ;
    private Integer code;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private String msg;
}