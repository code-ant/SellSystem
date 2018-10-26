package com.wang.sell.Utils;

import com.wang.sell.VO.ResultVO;

public class ResultVOUtil {
    public static ResultVO success(Object o){
        ResultVO resultVO = new ResultVO();
        resultVO.setData(o);
        resultVO.setMsg("成功");
        resultVO.setCode(0);
        return resultVO;
    }
    public static ResultVO success(){
        return null;
    }
    public static ResultVO error(Integer code, String msg){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }
}
