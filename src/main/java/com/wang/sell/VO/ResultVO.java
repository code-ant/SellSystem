package com.wang.sell.VO;

import lombok.Data;

@Data
public class ResultVO<T> {
    private Integer code;//错误码
    private  String msg;//提示信息
    private  T data;//具体内容
}
