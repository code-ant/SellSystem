package com.wang.sell.utils;

import java.util.Random;

public class KeyUtil {

    /**
     * 生成唯一主键
     * 时间+随机数
     * @return 唯一订单号
     */
    public static synchronized String genUniqueKey(){
        Random random = new Random();

        Integer number = random.nextInt(900000) + 100000;

        return System.currentTimeMillis() + String.valueOf(number);
    }
}
