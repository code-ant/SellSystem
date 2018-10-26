package com.wang.sell.exception;

import com.wang.sell.enums.ResultEnum;

public class SellException extends RuntimeException {

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        this.code = resultEnum.getCode();
    }
}
