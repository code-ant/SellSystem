package com.wang.sell.controller;

import com.wang.sell.DTO.OrderDTO;
import com.wang.sell.Utils.ResultVOUtil;
import com.wang.sell.VO.ResultVO;
import com.wang.sell.converter.OrderForm2OrderDTOConverter;
import com.wang.sell.enums.ResultEnum;
import com.wang.sell.exception.SellException;
import com.wang.sell.form.OrderForm;
import com.wang.sell.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {

    @Autowired
    private OrderService orderService;

    //创建订单
    @PostMapping("/create")
    public ResultVO<Map<String,String>> create(@Valid OrderForm orderForm,
                                               BindingResult bindingResult) {

        if(bindingResult.hasErrors()){
            log.error("【创建订单】参数不正确 ，orderform={}",orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }
        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
        if(CollectionUtils.isEmpty(orderDTO.getOrderDetailList())){
            log.error("【创建订单】，购物车不能为空");
            throw new SellException(ResultEnum.CART_EMPTY);
        }
        OrderDTO creatResult = orderService.create(orderDTO);
        Map<String,String> map = new HashMap<>();
        map.put("orderId",creatResult.getOrderId());

        return ResultVOUtil.success(map);
    }

    //订单列表
    @GetMapping("/list")
    public ResultVO<List<OrderDTO>> listResultVO(@RequestParam("openid") String openid,
                                                 @RequestParam(value = "page",defaultValue = "0") Integer page,
                                                 @RequestParam(value = "size",defaultValue = "10") Integer size){
        if(StringUtils.isEmpty(openid)){
            log.error("[查询列表]，openid为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        PageRequest request = PageRequest.of(page,size);
        Page<OrderDTO> orderDTOPage = orderService.findList(openid,request);

        //转换Date -> long

        return  ResultVOUtil.success(orderDTOPage.getContent());
    }

    //订单详情

    //取消订单
}
