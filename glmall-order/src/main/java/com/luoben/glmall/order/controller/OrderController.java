package com.luoben.glmall.order.controller;

import com.luoben.common.utils.PageUtils;
import com.luoben.common.utils.R;
import com.luoben.glmall.order.entity.OrderEntity;
import com.luoben.glmall.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 * 订单
 *
 * @author luoben
 * @email luoben@gmail.com
 * @date 2020-05-19 16:47:07
 */
@RestController
@RequestMapping("order/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 根据订单号查询订单
     * @param orderSn
     * @return
     */
    @GetMapping("/status/{orderSn}")
    public R getOrderByOrderSn(@PathVariable("orderSn") String orderSn){
       OrderEntity orderEntity= orderService.getOrderByOrderSn(orderSn);
       return R.ok().setData(orderEntity);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("order:order:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = orderService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("order:order:info")
    public R info(@PathVariable("id") Long id){
		OrderEntity order = orderService.getById(id);

        return R.ok().put("order", order);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("order:order:save")
    public R save(@RequestBody OrderEntity order){
		orderService.save(order);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("order:order:update")
    public R update(@RequestBody OrderEntity order){
		orderService.updateById(order);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("order:order:delete")
    public R delete(@RequestBody Long[] ids){
		orderService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
